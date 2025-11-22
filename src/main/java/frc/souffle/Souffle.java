package frc.souffle;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.BooleanSupplier;
import java.util.function.Consumer;
import java.util.function.DoubleSupplier;
import java.util.function.Supplier;

import org.littletonrobotics.junction.Logger;

import edu.wpi.first.util.struct.StructSerializable;

class SuppliedValue<T> {
    private Supplier<T> supplier;
    private Consumer<T> setter;

    public SuppliedValue(Supplier<T> supplier, Consumer<T> setter) {
        this.supplier = supplier;
        this.setter = setter;
    }

    public void update() {
        setter.accept(supplier.get());
    }
}


public class Souffle {
    private static Map<String, SuppliedValue<?>> valueSuppliers =
            new ConcurrentHashMap<>();

    public static void record(String key, DoubleSupplier supplier) {
        valueSuppliers.put(key, new SuppliedValue<>(supplier::getAsDouble,
                (v) -> Logger.recordOutput(key, v)));
    }

    public static void record(String key, BooleanSupplier supplier) {
        valueSuppliers.put(key, new SuppliedValue<>(supplier::getAsBoolean,
                (v) -> Logger.recordOutput(key, v)));
    }

    public static <T extends StructSerializable> void record(String key,
            Supplier<T> supplier) {
        var value = supplier.get();

        var maybeStruct = StructRegistry.getStruct(value.getClass());
        if (maybeStruct.isPresent()) {
            valueSuppliers.put(key, new SuppliedValue<T>(supplier::get,
                    (v) -> Logger.recordOutput(key, v)));
        } else {
            return;
        }
    }

    /**
     * Must be called in robotPeriodic. Should not be called anywhere else.
     */
    public static void update() {
        for (var sup : valueSuppliers.values()) {
            sup.update();
        }
    }
}
