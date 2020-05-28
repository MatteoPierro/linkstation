package com.matteopierro.linkstation.infrastructure;

import com.matteopierro.linkstation.domain.Display;
import com.matteopierro.linkstation.domain.model.Device;
import com.matteopierro.linkstation.domain.model.LinkStation;

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
        display("No link station within reach for point "+ device.point());
    }

    @Override
    public void bestLinkStationFor(Device device, LinkStation station) {
        String message = "Best link station for point " + device.point()
                + " is " + station.point() + " with power " + station.powerFor(device);
        display(message);
    }

    private void display(String message) {
        printStream.println(message);
        printStream.flush();
    }
}
