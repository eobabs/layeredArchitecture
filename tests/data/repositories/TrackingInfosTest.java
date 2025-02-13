package data.repositories;

import data.models.TrackingInfo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class TrackingInfosTest {
    TrackingInfos trackingInfos;
    TrackingInfo trackingInfoOne;
    TrackingInfo trackingInfoTwo;


    @BeforeEach
    public void setUp() {
        trackingInfos = new TrackingInfos();
        trackingInfoOne = new TrackingInfo(100,"In Transit","Sabo");
        trackingInfoTwo = new TrackingInfo(101,"In Transit","Yaba");

    }

    @Test
    public void testThatNewTrackingInfoRepositoryIsEmpty() {

        assertEquals(0, trackingInfos.count());
    }

    @Test
    public void testThatTrackingInfosCanSaveTrackingInfos() {

        trackingInfos.save(trackingInfoOne);

        assertEquals(1, trackingInfos.count());


    }

    @Test
    public void testThatNullCannottBeSaved(){

        assertThrows(IllegalArgumentException.class, ()->trackingInfos.save(null));
    }

    @Test
    public void testThatTrackingInfosCanSaveMultipleTrackingInfos(){

        trackingInfos.saveAll(trackingInfoOne, trackingInfoTwo);
        assertEquals(2, trackingInfos.count());

    }

    @Test
    public void testThatTrackingInfosCanFindTrackingInfoById() {
        trackingInfos.save(trackingInfoOne);
        TrackingInfo foundTrackingInfo = trackingInfos.findById(trackingInfoOne.getId());
        assertEquals(trackingInfoOne, foundTrackingInfo);
    }

    @Test
    public void testThatTrackingInfosCanDeleteTrackingInfo() {
        trackingInfos.save(trackingInfoOne);
        assertEquals(1, trackingInfos.count());
        trackingInfos.delete(trackingInfoOne.getId());
        assertEquals(0, trackingInfos.count());
    }

    @Test
    public void testThatDeleteThrowsExceptionWithInvalidId(){
        trackingInfos.save(trackingInfoOne);
        assertThrows(NullPointerException.class, ()->trackingInfos.delete(419));
    }

    @Test
    public void testThatTrackingInfosCanDeleteAllTrackingInfos() {
        trackingInfos.save(trackingInfoOne);
        trackingInfos.save(trackingInfoTwo);
        assertEquals(2, trackingInfos.count());
        trackingInfos.deleteAll();
        assertEquals(0, trackingInfos.count());
    }

    @Test
    public void testThatTrackingInfosCanUpdateTrackingInfo() {
        trackingInfos.save(trackingInfoOne);
        trackingInfoOne.setStatus("Delivered");
        trackingInfos.save(trackingInfoOne);
        assertEquals(1, trackingInfos.count());
    }

    @Test
    public void testThatTrackingInfosCanDeleteMultipleTrackingInfos() {
        trackingInfos.save(trackingInfoOne);
        trackingInfos.save(trackingInfoTwo);
        assertEquals(2, trackingInfos.count());

        trackingInfos.deleteAll(trackingInfoOne,trackingInfoTwo);
        assertEquals(0, trackingInfos.count());
    }

    @Test
    public void testThatTrackingInfosCanDeleteMultipleTrackingInfosById() {
        trackingInfos.save(trackingInfoOne);
        trackingInfos.save(trackingInfoTwo);
        assertEquals(2, trackingInfos.count());

        trackingInfos.deleteAllById(trackingInfoOne.getId(),trackingInfoTwo.getId());

        assertEquals(0, trackingInfos.count());
    }

    @Test
    public void testThatTrackingInfosCanFindTrackingInfoAllTrackingInfoById() {
        trackingInfos.save(trackingInfoOne);
        trackingInfos.save(trackingInfoTwo);
        ArrayList<TrackingInfo> foundTrackingInfos = trackingInfos.findAllById(trackingInfoOne.getId(),
                trackingInfoTwo.getId());
        assertEquals(2, foundTrackingInfos.size());
    }
}