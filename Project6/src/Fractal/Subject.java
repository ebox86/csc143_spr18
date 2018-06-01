package Fractal;

/**
 * Subject - used for Observer model
 * @author evankoh
 * @version csc143
 */
public interface Subject {
    public void attach(Observer obs);
    public void detach(Observer obs);
    public void notifyAllObservers();
    public int  getState();
}
