package de.tum.in.oose.bumpers.cars;

import java.awt.Image;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import de.tum.in.oose.bumpers.cars.instruments.Instrument;
import de.tum.in.oose.bumpers.ui.InstrumentPanel;

public class UserCar extends Car {
    public static Image DEFAULT_IMAGE;

    private ArrayList<Instrument> instruments = new ArrayList<Instrument>();

    private InstrumentPanel instrumentPanel;

    public UserCar() {
        super();
        instrumentPanel = new InstrumentPanel(this);
    }

    public void initiate(int max_x, int max_y) {
        setBody(DEFAULT_IMAGE);
        this.position.x = 0;
        this.position.y = max_y;
        setDirection(90);
        this.speed = 5;
        this.isCrunched = false;
        notifyInstruments();
    }

    public void subscribeInstrument(Instrument component) {
        if (component != null && !this.instruments.contains(component)) {
            this.instruments.add(component);
        }
    }

    public void unsubscribeInstrument(Instrument instrument) {
        if (instrument != null && this.instruments.contains(instrument)) {
            this.instruments.remove(instrument);
        }
    }

    public synchronized void notifyInstruments() {
        Iterator<Instrument> iter = instruments.iterator();
        while (iter.hasNext()) {
            Instrument aComponent = iter.next();
            aComponent.updateInstrument();
        }
    }

    public List<Instrument> getInstruments() {
        return instruments;
    }

    public synchronized void updatePosition(int max_x, int max_y) {
        super.updatePosition(max_x, max_y);
        notifyInstruments();
    }

    public InstrumentPanel getInstrumentPanel() {
        return this.instrumentPanel;
    }
}
