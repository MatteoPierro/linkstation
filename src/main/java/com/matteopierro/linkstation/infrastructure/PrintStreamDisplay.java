package com.matteopierro.linkstation.infrastructure;

import com.matteopierro.linkstation.domain.Display;
import com.matteopierro.linkstation.domain.model.Device;
import com.matteopierro.linkstation.domain.model.LinkStation;
import com.matteopierro.linkstation.domain.model.Point;
import com.matteopierro.linkstation.domain.model.Power;

import java.io.PrintStream;

public class PrintStreamDisplay implements Display {

    private final PrintStream printStream;

    public static Display consoleDisplay() {
        return new PrintStreamDisplay(System.out);
    }

    protected PrintStreamDisplay(PrintStream printStream) {
        this.printStream = printStream;
    }

    @Override
    public void noLinkStationFor(Device device) {
        printStream.println("No link station within reach for point "+ device.point());
        printStream.flush();
    }

    @Override
    public void bestLinkStationFor(Device device, LinkStation station) {
        Point devicePoint = device.point();
        Point stationPoint = station.point();
        Power power = station.powerFor(device);
        printStream.println("Best link station for point " + devicePoint + " is " + stationPoint + " with power " + power);
        printStream.flush();
    }
}
