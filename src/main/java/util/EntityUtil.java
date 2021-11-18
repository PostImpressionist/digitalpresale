package util;

import model.hardware.Hardware;

import java.util.List;

/**
 * created by E.K.
 * 2021 November 18
 **/

public class EntityUtil {

    public static Double getTotalPrice(List<Hardware> hardwareList) {
        return hardwareList.isEmpty() ? 0 : hardwareList.stream().mapToDouble(Hardware::getPrice).sum();
    }
}
