package cs134.miracosta.edu.Model;

import java.util.Objects;

/**
 * The <code>InteriorRoom</code> class calculates the amount of paint needed
 * to re-coat a room.
 *
 * @author William Craycroft
 * @version 1.0
 */
public class InteriorRoom {

    private int mDoors;
    private int mWindows;

    private double mHeight;
    private double mLength;
    private double mWidth;

    /** Standard door area (3 feet x 7 feet) */
    public static final double DOOR_AREA = 21.0;
    /**
     *
     */
    public static final double WINDOW_AREA = 16.0;
    public static final double SQ_FEET_PER_GALLON = 275.0;

    /**
     * Instantiates a new <code>InteriorRoom</code> provided with number of doors windows,
     * and its dimensions: width, height and length.
     *
     * @param doors The number of doors in the room.
     * @param windows The number of windows in the room.
     * @param height The height of the room.
     * @param length The length of the room.
     * @param width The width of the room.
     */
    public InteriorRoom(int doors, int windows, double height, double length, double width) {
        mDoors = doors;
        mWindows = windows;
        mHeight = height;
        mLength = length;
        mWidth = width;
    }

    // Getters
    public int getDoors() {
        return mDoors;
    }

    public int getWindows() {
        return mWindows;
    }

    public double getHeight() {
        return mHeight;
    }

    public double getLength() {
        return mLength;
    }

    public double getWidth() {
        return mWidth;
    }

    // Setters
    public void setDoors(int doors) {
        mDoors = doors;
    }

    public void setWindows(int windows) {
        mWindows = windows;
    }

    public void setHeight(double height) {
        mHeight = height;
    }

    public void setLength(double length) {
        mLength = length;
    }

    public void setWidth(double width) {
        mWidth = width;
    }

    @Override
    public String toString() {
        return "InteriorRoom{" +
                "mDoors=" + mDoors +
                ", mWindows=" + mWindows +
                ", mHeight=" + mHeight +
                ", mLength=" + mLength +
                ", mWidth=" + mWidth +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InteriorRoom that = (InteriorRoom) o;
        return mDoors == that.mDoors &&
                mWindows == that.mWindows &&
                Double.compare(that.mHeight, mHeight) == 0 &&
                Double.compare(that.mLength, mLength) == 0 &&
                Double.compare(that.mWidth, mWidth) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(mDoors, mWindows, mHeight, mLength, mWidth);
    }

    // Helper methods
    public double doorAndWindowArea() {
        return mDoors * DOOR_AREA + mWindows * WINDOW_AREA;
    }

    public double totalSurfaceArea() {
        return 2.0 * (mWidth * mHeight + mLength * mHeight);
    }

    public double wallSurfaceArea() {
        return totalSurfaceArea() - doorAndWindowArea();
    }

    public double gallonsOfPaintRequired() {
        return wallSurfaceArea() / SQ_FEET_PER_GALLON;
    }
}
