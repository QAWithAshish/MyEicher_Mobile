package pageObjects;

import DataFactory.TrackingView;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import logger.LogReporter;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import utils.ScreenShotUtils;

import java.util.List;

public class FleetTrackingScreenV1 extends BasePage {

    public FleetTrackingScreenV1(AppiumDriver driver) {
        super(driver);

    }

    static String storedVehicleNumber;

    @AndroidFindBy(id = "in.here.volvo.android:id/fab_search")
    WebElement searchButton;

    @AndroidFindBy(accessibility = "Vehicle")
    WebElement filterByVehicle;

    @AndroidFindBy(accessibility = "Location")
    WebElement filterByLocation;

    @AndroidFindBy(id = "in.here.volvo.android:id/et_search")
    WebElement locationSearchBar;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeImage[@name=\"timeseries_filter\"]/preceding-sibling::*")
    @AndroidFindBy(id = "in.here.volvo.android:id/iv_filter")
    WebElement listviewFilter;

    @iOSXCUITFindBy(iOSNsPredicate = "label CONTAINS \"View by Vehicle\"")
    @AndroidFindBy(xpath = "//*[@text='View by Vehicle']")
    WebElement viewByVehicle;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeTable/XCUIElementTypeCell/XCUIElementTypeStaticText[`visible==1`]")
    @AndroidFindBy(id = "in.here.volvo.android:id/tv_vehicle_number")
    List<WebElement> vehiclesList;

    @AndroidFindBy(id = "in.here.volvo.android:id/tv_address")
    List<WebElement> address;

    @AndroidFindBy(id = "in.here.volvo.android:id/tvOurServices")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[4]")
    WebElement ourServicesMenuOption;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout[2]/androidx.recyclerview.widget.RecyclerView/android.widget.RelativeLayout[3]/android.widget.ImageView")
    WebElement fleetTrackingOption;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"in.here.volvo.android:id/child\").text(\"Track\")")
    WebElement trackOption;

    @iOSXCUITFindBy(accessibility = "Done")
    @AndroidFindBy(id = "in.here.volvo.android:id/btn_done")
    WebElement doneButton;

    @iOSXCUITFindBy(iOSNsPredicate = "label CONTAINS \"DONE\"")
    @AndroidFindBy(id = "in.here.volvo.android:id/btn_done")
    WebElement doneBottomSHeet;

    @AndroidFindBy(id = "in.here.volvo.android:id/tv_selected_vehicle")
    WebElement selectedVehicle;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"APPLY\"]")
    @AndroidFindBy(id = "in.here.volvo.android:id/btn_apply")
    WebElement applyFilter;


    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"Google Map\"]/android.view.View[@content-desc!=\"\"]")
    List<WebElement> individualVehicleOnMap;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"Google Map\"]/android.view.View[@content-desc=\"\"]")
    List<WebElement> vehicleClusters;


    @AndroidFindBy(id = "in.here.volvo.android:id/tv_vehicles_count")
    WebElement vehicleCountGridHeader;


    @AndroidFindBy(id = "in.here.volvo.android:id/iv_close")
    WebElement closeBottomSheet;

    @AndroidFindBy(id = "in.here.volvo.android:id/tvHeader")
    WebElement detailedViewHeader;


    @iOSXCUITFindBy(accessibility = "Moving")
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Moving']")
    WebElement movingStatus;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@label = \"Moving\"]/preceding-sibling::XCUIElementTypeStaticText")
    @AndroidFindBy(id = "in.here.volvo.android:id/tv_moving_count")
    WebElement movingValue;


    @AndroidFindBy(id = "in.here.volvo.android:id/ll_moving")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@label = \"Moving\"]/preceding-sibling::XCUIElementTypeButton")
    WebElement movingButton;


    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeCell/XCUIElementTypeStaticText[`label == \"Moving\" AND visible==1`]")
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"in.here.volvo.android:id/tv_moving_status\").text(\"Moving\")")
    List<WebElement> movingVehicles;

    @iOSXCUITFindBy(accessibility = "Stopped")
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Stopped']")
    WebElement stoppedStatus;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@label = \"Stopped\"]/preceding-sibling::XCUIElementTypeStaticText")
    @AndroidFindBy(id = "in.here.volvo.android:id/tv_stopped_count")
    WebElement stoppedValue;

    @AndroidFindBy(id = "in.here.volvo.android:id/ll_stopped")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@label = \"Stopped\"]/preceding-sibling::XCUIElementTypeButton")
    WebElement stoppedButton;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeCell/XCUIElementTypeStaticText[`label == \"Stopped\" AND visible==1`]")
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"in.here.volvo.android:id/tv_moving_status\").text(\"Stopped\")")
    List<WebElement> stoppedVehicles;

    @iOSXCUITFindBy(accessibility = "Not Reachable")
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Not Reachable']")
    WebElement notReachableStatus;


    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@label = \"Not Reachable\"]/preceding-sibling::XCUIElementTypeStaticText")
    @AndroidFindBy(id = "in.here.volvo.android:id/tv_non_communicable_count")
    WebElement notReachableValue;

    @AndroidFindBy(id = "in.here.volvo.android:id/ll_non_communicable")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@label = \"Not Reachable\"]/preceding-sibling::XCUIElementTypeButton")
    WebElement notReachableButton;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeCell/XCUIElementTypeStaticText[`label == \"Not Reachable\" AND visible==1`]")
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"in.here.volvo.android:id/tv_moving_status\").text(\"Not Reachable\")")
    List<WebElement> notReachableVehicles;


    @iOSXCUITFindBy(accessibility = "Idling")
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Idling']")
    WebElement idleStatus;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@label =\"Idling\"]/preceding-sibling::XCUIElementTypeStaticText")
    @AndroidFindBy(id = "in.here.volvo.android:id/tv_idling_count")
    WebElement idleValue;

    @AndroidFindBy(id = "in.here.volvo.android:id/ll_idling")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@label =\"Idling\"]/preceding-sibling::XCUIElementTypeButton")
    WebElement idlingButton;


    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeCell/XCUIElementTypeStaticText[`label == \"Idling\" AND visible==1`]")
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"in.here.volvo.android:id/tv_moving_status\").text(\"Idling\")")
    List<WebElement> idleVehicles;

    @AndroidFindBy(id = "in.here.volvo.android:id/tv_flip_view")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"List\"]/preceding-sibling::XCUIElementTypeButton")
    WebElement listView;

    @AndroidFindBy(id = "in.here.volvo.android:id/tv_flip_view")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Map\"]/preceding-sibling::XCUIElementTypeButton")
    WebElement mapView;

    @AndroidFindBy(id = "in.here.volvo.android:id/mapLayout")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"currentLocation\"`]")
    WebElement mapLayout;

    @AndroidFindBy(id = "in.here.volvo.android:id/vehicle_track_bottom_sheet_l")
    @iOSXCUITFindBy(className = "XCUIElementTypeTable")
    WebElement listLayout;

    @AndroidFindBy(xpath = "//*[@resource-id='in.here.volvo.android:id/tvHeader' and @text='FLEET TRACKING']")
    @iOSXCUITFindBy(accessibility = "MY FLEETS")
    WebElement fleetTrackingTitle;


    @iOSXCUITFindBy(iOSNsPredicate = "label ENDSWITH \" L\" and visible==1")
    @AndroidFindBy(id = "in.here.volvo.android:id/tv_fuel")
    List<WebElement> vehicleFuelLevel;

    @iOSXCUITFindBy(iOSNsPredicate = "label CONTAINS \"KMs\" AND visible ==1")
    @AndroidFindBy(id = "in.here.volvo.android:id/tv_odometer_reading")
    List<WebElement> vehicleOdometer;

    @iOSXCUITFindBy(iOSNsPredicate = "(label CONTAINS \"AM\" OR label CONTAINS \"PM\" )AND visible == 1")
    @AndroidFindBy(id = "in.here.volvo.android:id/tv_last_updated")
    List<WebElement> vehicleLastUpdated;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeCell/XCUIElementTypeStaticText[`index==4 AND visible==1`]")
    @AndroidFindBy(id = "in.here.volvo.android:id/tv_health_status")
    List<WebElement> vehicleHealth;


    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeCell[`visible==1`]")
    @AndroidFindBy(xpath = "(//*[@resource-id='in.here.volvo.android:id/cv_list_item'])[1]")
    WebElement vehicleRegNo;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeOther/XCUIElementTypeStaticText[`visible==1`]")
    @AndroidFindBy(id = "in.here.volvo.android:id/tvHeader")
    WebElement verifyVehicleRegNo;


    @AndroidFindBy(id = "in.here.volvo.android:id/iv_filter")
    WebElement filteronPlaybackAndtrace;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == \"Current Status\"`]")
    @AndroidFindBy(xpath = "//android.widget.LinearLayout[@content-desc=\"Current Status\"]/android.widget.TextView")
    WebElement vehicleCurrentStatus;


    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == \"Playback & Trace\"`]")
    @AndroidFindBy(xpath = "//android.widget.LinearLayout[@content-desc=\"Playback & Trace\"]/android.widget.TextView")
    WebElement vehiclePlayBackAndTrace;


    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == \"Quick Links\"`]")
    @AndroidFindBy(xpath = "//android.widget.LinearLayout[@content-desc=\"Quick Links\"]/android.widget.TextView")
    WebElement vehicleQuickLinks;

    @iOSXCUITFindBy(iOSNsPredicate = "label CONTAINS \"Km/H\"")
    @AndroidFindBy(id = "in.here.volvo.android:id/tv_speed")
    WebElement vehicleRealTimeSpeed;

    @iOSXCUITFindBy(iOSNsPredicate = "label CONTAINS \"Current Location\"")
    @AndroidFindBy(id = "in.here.volvo.android:id/tv_current_location")
    WebElement vehicleRealTimeLocation;

    @iOSXCUITFindBy(iOSNsPredicate = "label CONTAINS \"Last Updated:\"")
    @AndroidFindBy(xpath = "(//*[@class='android.widget.LinearLayout'])[11]")
    WebElement vehicleRealTimeStatus;

    @iOSXCUITFindBy(iOSNsPredicate = "label BEGINSWITH \"Last Updated:\"")
    @AndroidFindBy(id = "in.here.volvo.android:id/tv_last_updated")
    WebElement vehicleRealTimeLastUpdated;

    @iOSXCUITFindBy(iOSNsPredicate = "label BEGINSWITH \"LAST UPDATED ON\"")
    @AndroidFindBy(id = "in.here.volvo.android:id/tv_last_updated_on")
    WebElement vehicleTabLastUpdated;

    @iOSXCUITFindBy(iOSNsPredicate = "label == \"Sweet Spot\"")
    @AndroidFindBy(id = "in.here.volvo.android:id/ll_sweet_spot")
    WebElement isDisplayRealTimeSweetSpot;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Sweet Spot\"]/following-sibling::XCUIElementTypeStaticText")
    @AndroidFindBy(id = "in.here.volvo.android:id/tv_sweet_spot_percentage")
    WebElement vehicleRealTimeSweetSpot;

    @iOSXCUITFindBy(iOSNsPredicate = "label == \"Odometer\"")
    @AndroidFindBy(id = "in.here.volvo.android:id/ll_odometer")
    WebElement isDisplayRealTimeOdometer;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Odometer\"]/following-sibling::XCUIElementTypeStaticText")
    @AndroidFindBy(id = "in.here.volvo.android:id/tvOdometerValue")
    WebElement vehicleRealTimeOdometer;

    @iOSXCUITFindBy(iOSNsPredicate = "label == \"DEF Level\"")
    @AndroidFindBy(id = "in.here.volvo.android:id/ll_def_level")
    WebElement isDisplayRealTimeDEFlevel;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"DEF Level\"]/following-sibling::XCUIElementTypeStaticText")
    @AndroidFindBy(id = "in.here.volvo.android:id/tv_def_level_percentage")
    WebElement vehicleRealTimeDEFlevel;

    @iOSXCUITFindBy(iOSNsPredicate = "label BEGINSWITH \"Since\"")
    @AndroidFindBy(id = "in.here.volvo.android:id/tv_24_since_in_hrs_card")
    WebElement vehiclePast24hrPerformance;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"IN PAST 24 HOURS\"]/following-sibling::XCUIElementTypeStaticText[contains(@label,\"KMs\")]")
    @AndroidFindBy(id = "in.here.volvo.android:id/tv_24_last_distance_travelled_value")
    WebElement vehicleDistanceTravelled;


    @iOSXCUITFindBy(iOSNsPredicate = "label CONTAINS \"Km/L\"")
    @AndroidFindBy(id = "in.here.volvo.android:id/tv_24_fuel_efficiency_value")
    WebElement vehicleFuelEfficiency;

    @iOSXCUITFindBy(iOSNsPredicate = "label CONTAINS \"Hrs\" OR label CONTAINS \"Mins\"")
    @AndroidFindBy(id = "in.here.volvo.android:id/tv_24_ignition_time_value")
    WebElement vehicleIgnitionTime;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[contains(@label,\"SHARE LIVE\")]/following-sibling::XCUIElementTypeButton")
    @AndroidFindBy(id = "in.here.volvo.android:id/btn_share_live_loc")
    WebElement vehicleShareLiveLocation;

    @iOSXCUITFindBy(iOSNsPredicate = "label == \"LOCATION SHARING DETAILS\"")
    @AndroidFindBy(id = "in.here.volvo.android:id/tvHeader")
    WebElement locationSharingHeader;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Mobile No.*\"]/following-sibling::XCUIElementTypeTextField")
    @AndroidFindBy(id = "in.here.volvo.android:id/etMobileNo")
    WebElement liveLocationPageMobileNoTf;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[contains(@name,\"First Name\")]/following-sibling::XCUIElementTypeTextField")
    @AndroidFindBy(id = "in.here.volvo.android:id/etFirstName")
    WebElement liveLocationPageFirstNameTf;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[contains(@name,\"Last Name\")]/following-sibling::XCUIElementTypeTextField")
    @AndroidFindBy(id = "in.here.volvo.android:id/etLastName")
    WebElement liveLocationPageLastNameTf;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[contains(@name,\"Email\")]/following-sibling::XCUIElementTypeTextField")
    @AndroidFindBy(id = "in.here.volvo.android:id/et_fls_email")
    WebElement liveLocationPageEmailTf;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeButton[@name=\"date icon\"]/preceding-sibling::*)[1]")
    @AndroidFindBy(id = "in.here.volvo.android:id/btnStartDateTime")
    WebElement liveLocationStartDateTimeBtn;

    @AndroidFindBy(id = "android:id/button1")
    WebElement startDateTimeOkBtn;

    @AndroidFindBy(id = "in.here.volvo.android:id/next")
    WebElement nextMonth;

    @AndroidFindBy(xpath = "//*[@resource-id='in.here.volvo.android:id/month_view']/android.view.View")
    WebElement dateInMonth;


    @iOSXCUITFindBy(className = "XCUIElementTypePickerWheel")
    List<WebElement> pickerWheel;


    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeButton[@name=\"date icon\"]/preceding-sibling::*)[2]")
    @AndroidFindBy(id = "in.here.volvo.android:id/btnEndDateTime")
    WebElement liveLocationEndDateTimeBtn;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"SUBMIT\"`]")
    @AndroidFindBy(id = "in.here.volvo.android:id/fls_submit_btn")
    WebElement liveLocationSubmitBtn;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[contains(@label,\"SHARE CURRENT\")]/following-sibling::XCUIElementTypeButton")
    @AndroidFindBy(id = "in.here.volvo.android:id/btn_share_current_loc")
    WebElement vehicleShareCurrentLocation;

    @iOSXCUITFindBy(accessibility = "Share Current Location")
    @AndroidFindBy(id = "in.here.volvo.android:id/dialog_title")
    WebElement ShareCurrentLocationTitle;

    @AndroidFindBy(xpath = "//*[@resource-id='in.here.volvo.android:id/cbCheckItem' and @checked='false']")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"UncheckedTerms\"`][1]")
    WebElement vehicleSelectionCheckbox;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"SHARE LOCATION\"`]")
    @AndroidFindBy(id = "in.here.volvo.android:id/share_location_confirm_btn")
    WebElement currentConfirmBtn;

    @AndroidFindBy(id = "android:id/content_preview_container")
    @iOSXCUITFindBy(accessibility = "UIActivityContentView")
    WebElement shareAppsWindow;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"Close\"`]")
    WebElement closeShareAppsWindow;

    @AndroidFindBy(id = "in.here.volvo.android:id/share_location_frame_close_btn")
    @iOSXCUITFindBy(accessibility = "cross invite")
    WebElement closeVehicleSharePopup;


    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeCollectionView/**/XCUIElementTypeStaticText")
    @AndroidFindBy(id = "in.here.volvo.android:id/chipItem")
    List<WebElement> currentSelectVehicleChecklist;

    @iOSXCUITFindBy(accessibility = "VEHICLE DETAILS")
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='VEHICLE DETAILS']")
    WebElement qlVehicleDetails;

    @iOSXCUITFindBy(accessibility = "ONROAD BREAKDOWN")
    @AndroidFindBy(id = "in.here.volvo.android:id/breakdownLayout")
    WebElement breakdownDisplayed;

    @iOSXCUITFindBy(accessibility = "FUEL SERVICES")
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='FUEL SERVICES']")
    WebElement qlFuelServices;

    @iOSXCUITFindBy(accessibility = "FUEL REFILL & DRAIN")
    @AndroidFindBy(id = "in.here.volvo.android:id/tvHeader")
    WebElement qlAllTabTitle;

    @iOSXCUITFindBy(accessibility = "FUEL GRAPH")
    WebElement fuelGraph;


    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"Fuel Refill\"`]")
    @AndroidFindBy(id = "in.here.volvo.android:id/rbFuelRefillFM")
    WebElement fsFuelRefill;

    @iOSXCUITFindBy(iOSNsPredicate = "value == \"View by Vehicle\"")
    @AndroidFindBy(id = "in.here.volvo.android:id/btnFilter")
    WebElement fsFilterBtn;

    @iOSXCUITFindBy(iOSNsPredicate = "value == \"View by Vehicle\"")
    @AndroidFindBy(id = "in.here.volvo.android:id/filterByTextView")
    WebElement fsFilterBy;

    @iOSXCUITFindBy(accessibility = "View by Vehicle")
    @AndroidFindBy(xpath = "(//android.widget.TextView[@text='View by Vehicle'])")
    WebElement fsFilterByVehicle;

    @iOSXCUITFindBy(iOSNsPredicate = "value == \"Chassis Or Registration Number\"")
    @AndroidFindBy(id = "in.here.volvo.android:id/searchByVINEditText")
    WebElement SearchByRegNum;

    @iOSXCUITFindBy(accessibility = "FUEL GRAPH")
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='FUEL GRAPH']")
    WebElement qlFuelGraph;

    @AndroidFindBy(id = "in.here.volvo.android:id/imgFil")
    WebElement qlVehicleFilter;

    @AndroidFindBy(id = "in.here.volvo.android:id/rlVehicle")
    WebElement qlVehicleFilterByVehicle;

    @AndroidFindBy(xpath = "(//*[@resource-id='in.here.volvo.android:id/rlCheck'])[1]")
    WebElement filterByVehicleSelect;

    @AndroidFindBy(id = "in.here.volvo.android:id/llFilterViewRightDuration")
    WebElement filterByVehicleDoneBtn;

    @AndroidFindBy(id = "in.here.volvo.android:id/llFilterApply")
    WebElement qlFuelGraphFilterApply;

    @iOSXCUITFindBy(accessibility = "Refill Summary")
    @AndroidFindBy(id = "in.here.volvo.android:id/txtFuel")
    WebElement fuelLevelText;

    @iOSXCUITFindBy(accessibility = "FLEET INSIGHT")
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='FLEET INSIGHT']")
    WebElement qlFleetInsight;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == \"Vehicle Usage\"`]")
    WebElement vehicleUsage;

    @AndroidFindBy(id = "in.here.volvo.android:id/fuelRadioBtn")
    WebElement fuelTab;

    @AndroidFindBy(id = "in.here.volvo.android:id/safetyRadioBtn")
    WebElement safetyTab;

    @AndroidFindBy(id = "in.here.volvo.android:id/drivingBehaviourRadioBtn")
    WebElement drivingBehaviourTab;

    @AndroidFindBy(id = "in.here.volvo.android:id/vehicleUsageRadioBtn")
    WebElement vehicleUsageTab;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeWindow[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther[3]/XCUIElementTypeOther")
    @AndroidFindBy(id = "in.here.volvo.android:id/rl_bottom_sheet_toggle")
    WebElement bottomSheetToggle;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"in.here.volvo.android:id/tv_pilot_name\").text(\"NO\")")
    @iOSXCUITFindBy(accessibility = "No Pilot Assigned")
    WebElement nopilotAssignedScenario;



    public FleetTrackingScreenV1 quickLinksTabFleetInsight() {

        Assert.assertTrue(actions.iselementVisible(vehicleQuickLinks), "Vehicle quick links tab not display");
        vehicleQuickLinks.click();
        ScreenShotUtils.attachScreenshot();
        LogReporter.Reporter("Vehicle quick links tabs is display");
        Assert.assertTrue(actions.iselementVisible(qlFleetInsight), "Fleet insight tab not display");
        qlFleetInsight.click();
        ScreenShotUtils.attachScreenshot();
        LogReporter.Reporter("Click on fleet insight tab");
        if (driver.getCapabilities().getPlatformName().toString().equalsIgnoreCase(Platform.IOS.toString())) {
            Assert.assertTrue(actions.iselementVisible(vehicleUsage));
        } else {
            Assert.assertTrue(actions.iselementVisible(qlAllTabTitle), "Vehicle fleet insight is not display");
            LogReporter.Reporter("Vehicle fleet insight is display and value : " + qlAllTabTitle.getText());
        }
        Assert.assertTrue(actions.iselementVisible(vehicleUsageTab), "Vehicle usage tab is not visible");
        LogReporter.Reporter("Vehicle usage tab is visible and value : " + vehicleUsageTab.getText());
        Assert.assertTrue(actions.iselementVisible(fuelTab), "Fuel tab is not visible");
        LogReporter.Reporter("Fuel tab is visible and value : " + fuelTab.getText());
        Assert.assertTrue(actions.iselementVisible(safetyTab), "Safety tab is not visible");
        LogReporter.Reporter("Safety tab is visible and value  : " + safetyTab.getText());
        Assert.assertTrue(actions.iselementVisible(drivingBehaviourTab), "Driving behaviour tab is not visible");
        LogReporter.Reporter("Driving behaviour tab is visible and value : " + drivingBehaviourTab.getText());
        return this;
    }

    public FleetTrackingScreenV1 quickLinksTabFuelGraph() {

        Assert.assertTrue(actions.iselementVisible(vehicleQuickLinks), "Vehicle quick links tab not display");
        vehicleQuickLinks.click();
        ScreenShotUtils.attachScreenshot();
        LogReporter.Reporter("Vehicle quick links tabs is display");
        Assert.assertTrue(actions.iselementVisible(qlFuelServices), "Fuel services tab not display");
        qlFuelGraph.click();
        ScreenShotUtils.attachScreenshot();
        LogReporter.Reporter("Click on fuel graph page");
        if (driver.getCapabilities().getPlatformName().toString().equalsIgnoreCase(Platform.ANDROID.toString())) {
            qlVehicleFilter.click();
            qlVehicleFilterByVehicle.click();
            LogReporter.Reporter("Filter by vehicle");
            ScreenShotUtils.attachScreenshot();
            filterByVehicleSelect.click();
            LogReporter.Reporter("Select vehicle");
            filterByVehicleDoneBtn.click();
            qlFuelGraphFilterApply.click();
            ScreenShotUtils.attachScreenshot();
            Assert.assertTrue(actions.iselementVisible(fuelLevelText), "Vehicle fuel graph is not display");
            LogReporter.Reporter("Vehicle fuel Level: " + fuelLevelText.getText());
            LogReporter.Reporter("Vehicle fuel graph is display and value : " + qlAllTabTitle.getText());
        } else {
            Assert.assertTrue(actions.iselementVisible(fuelLevelText), "Vehicle fuel graph is not display");
            LogReporter.Reporter("Vehicle refill Summary: " + fuelLevelText.getText());
            LogReporter.Reporter("Vehicle fuel graph is display and value : " + fuelGraph.getText());
        }
        return this;
    }

    public FleetTrackingScreenV1 quickLinksTabFuelServices() {
        Assert.assertTrue(actions.iselementVisible(vehicleQuickLinks), "Vehicle quick links tab not display");
        vehicleQuickLinks.click();
        ScreenShotUtils.attachScreenshot();
        LogReporter.Reporter("Vehicle quick links tabs is display");
        Assert.assertTrue(actions.iselementVisible(qlFuelServices), "Fuel services tab not display");
        qlFuelServices.click();
        ScreenShotUtils.attachScreenshot();
        LogReporter.Reporter("Click on fuel services page");
        waitForAndroidProgresBar(15);
        Assert.assertTrue(actions.iselementVisible(qlAllTabTitle), "Vehicle fuel refill and drain is display");
        LogReporter.Reporter("Vehicle fuel refill and drain is display and value : " + qlAllTabTitle.getText());
        Assert.assertTrue(fsFuelRefill.isEnabled(), "Fuel refill is enable");
        fsFuelRefill.click();
        ScreenShotUtils.attachScreenshot();
        LogReporter.Reporter("Clicked on Fuel Refill Tab");
        Assert.assertTrue(fsFuelRefill.isEnabled(), "Fuel refill is enable");
        if (driver.getCapabilities().getPlatformName().toString().equalsIgnoreCase(Platform.IOS.toString())) {
            driver.getPageSource();
            actions.sleep(2);
        }
        fsFilterBtn.click();
        LogReporter.Reporter("Clicked on filter Tab");
        fsFilterBy.click();
        ScreenShotUtils.attachScreenshot();
        LogReporter.Reporter("Opening filter dropdown");
        fsFilterByVehicle.click();
        LogReporter.Reporter("Selecting view by vehicle");
        ScreenShotUtils.attachScreenshot();
        LogReporter.Reporter("select filter by vehicle");
        SearchByRegNum.click();
        sendKeys(SearchByRegNum, storedVehicleNumber);
        LogReporter.Reporter("Click on Search By Reg Number");
        ScreenShotUtils.attachScreenshot();
        LogReporter.Reporter("Click on vehicle registration number");
        if (driver.getCapabilities().getPlatformName().toString().equalsIgnoreCase(Platform.IOS.toString())) {
            driver.getPageSource();
            actions.sleep(2);
        }
        waitForAndroidProgresBar(1);
        return this;
    }


    public FleetTrackingScreenV1 quickLinksTabVehicleDetails() {

        Assert.assertTrue(actions.iselementVisible(vehicleQuickLinks), "Vehicle quick links tab not display");
        vehicleQuickLinks.click();
        LogReporter.Reporter("Vehicle quick links tabs is display");
        ScreenShotUtils.attachScreenshot();
        Assert.assertTrue(actions.iselementVisible(qlVehicleDetails), "Vehicle details tab not display");
        qlVehicleDetails.click();
        ScreenShotUtils.attachScreenshot();
        LogReporter.Reporter("Click on Vehicle details page");
        Assert.assertTrue(actions.iselementVisible(breakdownDisplayed));
        LogReporter.Reporter("Break Down Displayed");
        if (driver.getCapabilities().getPlatformName().toString().contains(Platform.ANDROID.toString())) {
            driver.navigate().back();
            Assert.assertTrue(actions.iselementVisible(qlVehicleDetails), "Vehicle details tab not display");
        }
        return this;
    }

    public void selectVehicleFromCheckList(List<WebElement> elements) {

        for (WebElement e : elements) {
            String getVehicle = e.getText();
            LogReporter.Reporter("Vehicle selected are : " + getVehicle);
        }
    }

    public FleetTrackingScreenV1 shareVehicleCurrentLocation(){
        Assert.assertTrue(actions.iselementVisible(bottomSheetToggle));
        actions.pullUpBottomSheet(bottomSheetToggle, vehiclePlayBackAndTrace, 10);
        vehicleShareCurrentLocation.click();
        ScreenShotUtils.attachScreenshot();
        Assert.assertTrue(actions.iselementVisible(ShareCurrentLocationTitle), "Share current location title not display");
        LogReporter.Reporter("Current location screen title : " + ShareCurrentLocationTitle.getText());
        vehicleSelectionCheckbox.click();
        ScreenShotUtils.attachScreenshot();
        LogReporter.Reporter("clicked on Vehicle");
        selectVehicleFromCheckList(currentSelectVehicleChecklist);
        Assert.assertTrue(actions.iselementVisible(currentConfirmBtn));
        currentConfirmBtn.click();
        ScreenShotUtils.attachScreenshot();
        LogReporter.Reporter("Current location sharing Submit button");
        if (driver.getCapabilities().getPlatformName().toString().equalsIgnoreCase(Platform.IOS.toString())) {
            Assert.assertTrue(actions.iselementVisible(shareAppsWindow));
            LogReporter.Reporter("Share Apps Window Opened");
            closeShareAppsWindow.click();
            Assert.assertTrue(actions.iselementVisible(closeVehicleSharePopup));
            closeVehicleSharePopup.click();
        } else {
            Assert.assertTrue(actions.iselementVisible(shareAppsWindow));
            driver.navigate().back();
            Assert.assertTrue(actions.iselementVisible(closeVehicleSharePopup));
            closeVehicleSharePopup.click();
        }
        return this;
    }

    public FleetTrackingScreenV1 shareVehicleLiveLocation(){
        Assert.assertTrue(actions.iselementVisible(bottomSheetToggle));
        actions.pullUpBottomSheet(bottomSheetToggle, vehiclePlayBackAndTrace, 10);
        vehicleShareLiveLocation.click();
        ScreenShotUtils.attachScreenshot();
        Assert.assertTrue(actions.iselementVisible(liveLocationSubmitBtn));
        Assert.assertTrue(actions.iselementVisible(locationSharingHeader), "Location sharing details title not display");
        LogReporter.Reporter("Live location sharing title " + locationSharingHeader.getText());
        Assert.assertTrue(actions.iselementVisible(liveLocationPageMobileNoTf));
        sendKeys(liveLocationPageMobileNoTf, "9999999999");
        LogReporter.Reporter("Enter mobile number:9999999999");
        Assert.assertTrue(actions.iselementVisible(liveLocationPageFirstNameTf));
        sendKeys(liveLocationPageFirstNameTf, "Rohit");
        LogReporter.Reporter("Enter user name :Rohit ");
        Assert.assertTrue(actions.iselementVisible(liveLocationPageLastNameTf));
        sendKeys(liveLocationPageLastNameTf, "Singh");
        LogReporter.Reporter("Enter user last name:Singh");
        Assert.assertTrue(actions.iselementVisible(liveLocationPageEmailTf));
        sendKeys(liveLocationPageEmailTf, "example@gmail.com");
        LogReporter.Reporter("Enter user email address:example@gmail.com");
        Assert.assertTrue(actions.iselementVisible(liveLocationStartDateTimeBtn));
        liveLocationStartDateTimeBtn.click();
        LogReporter.Reporter("Select start date ");
        if (driver.getCapabilities().getPlatformName().toString().equalsIgnoreCase(Platform.ANDROID.toString())) {
            startDateTimeOkBtn.click();
            startDateTimeOkBtn.click();
        } else {
            actions.iselementVisible(doneButton);
            sendKeys(pickerWheel.get(2), String.valueOf(actions.getMin(15)));

        }
        Assert.assertTrue(actions.iselementVisible(liveLocationEndDateTimeBtn));
        liveLocationEndDateTimeBtn.click();
        if (driver.getCapabilities().getPlatformName().toString().equalsIgnoreCase(Platform.ANDROID.toString())) {
            startDateTimeOkBtn.click();
            Assert.assertTrue(actions.iselementVisible(nextMonth));
            nextMonth.click();
            LogReporter.Reporter("Date is " + dateInMonth.getText());
            dateInMonth.click();
            startDateTimeOkBtn.click();
        } else {
            actions.iselementVisible(doneButton);
            try {
                actions.tapOnWheel(pickerWheel.get(0), 5);
                actions.sleep(1);
                sendKeys(pickerWheel.get(3), "AM");
            } catch (Exception ex) {

                sendKeys(pickerWheel.get(1), String.valueOf(actions.getHours(1)));
            }
        }
        ScreenShotUtils.attachScreenshot();
        try {

            liveLocationSubmitBtn.click();
            LogReporter.Reporter("User live location submit button");
            ScreenShotUtils.attachScreenshot();

        } catch (Exception ex) {

        }
        if (driver.getCapabilities().getPlatformName().toString().contains(Platform.ANDROID.toString())) {
            waitForAndroidProgresBar(2);
        } else {
            try {
                Assert.assertTrue(actions.iselementVisible(vehicleShareLiveLocation, actions.shortTimeout));
            } catch (Exception | AssertionError ex) {
                LogReporter.INFO(ex.getMessage());
            }
        }
        return this;
    }

    public FleetTrackingScreenV1 noPilotAssigned() {
        Assert.assertTrue(actions.iselementVisible(bottomSheetToggle));
        actions.pullUpBottomSheet(bottomSheetToggle, vehiclePlayBackAndTrace, 10);
        ScreenShotUtils.attachScreenshot();
        Assert.assertTrue(actions.iselementVisible(nopilotAssignedScenario));
        navigateToHome();
        return this;
    }

    public FleetTrackingScreenV1 allRealTimeVehicleDetails(){
        Assert.assertTrue(actions.iselementVisible(bottomSheetToggle));
        actions.pullUpBottomSheet(bottomSheetToggle, vehiclePlayBackAndTrace, 10);
        ScreenShotUtils.attachScreenshot();
        validateAllRealTimeOdometer();
        validatePast24HourPerformance();
        return this;
    }

    public void validatePast24HourPerformance() {
        String vehiclePerformance = vehiclePast24hrPerformance.getText();
        LogReporter.Reporter("Vehicle past 24 hour performance :" + vehiclePerformance);
        String vehicleTravelled = vehicleDistanceTravelled.getText();
        vehicleTravelled = vehicleTravelled.toLowerCase()
                .replace("km", "")
                .replace("s", "")
                .trim();
        LogReporter.Reporter("The value of vehicle distance travelled " + vehicleTravelled);
        Assert.assertTrue(Integer.parseInt(vehicleTravelled) >= 0, "Unable to validate vehicle distance travelled.");

        String vehicleEfficiency = vehicleFuelEfficiency.getText();
        vehicleEfficiency = vehicleEfficiency.toLowerCase().replace("Km/l", "").trim();
        LogReporter.Reporter("The value of vehicle fuel efficiency " + vehicleEfficiency);
        String vehicleIgnition = vehicleIgnitionTime.getText();
        vehicleIgnition = vehicleIgnition.toLowerCase().replace("hrs", ":")
                .replace("mins", "").trim();
        LogReporter.Reporter("The value of vehicle fuel ignition " + vehicleIgnition);
    }

    public void validateAllRealTimeOdometer() {

        String lastUpdatedOnMap = vehicleTabLastUpdated.getText();
        lastUpdatedOnMap = lastUpdatedOnMap.toLowerCase().replace("last updated on", "").trim();
        String lastUpdatedOnTab = vehicleRealTimeLastUpdated.getText();
        lastUpdatedOnTab = lastUpdatedOnTab.toLowerCase().replace("last updated:", "").trim();
        Assert.assertEquals(lastUpdatedOnMap, lastUpdatedOnTab, "Vehicle Last update not match");
        Assert.assertTrue(isDisplayRealTimeOdometer.isDisplayed(), "Real time odometer is not display");
        LogReporter.Reporter("Vehicle odometer is display");
        String vehicleOdometer = vehicleRealTimeOdometer.getText();
        LogReporter.Reporter("The value of vehicles odometer is " + vehicleOdometer);
        vehicleOdometer = vehicleOdometer.toLowerCase().replace(",", "")
                .replace("kms", "")
                .replace("km", "")
                .replace("", "").trim();
        LogReporter.Reporter("The value of vehicles odometer in Integer " + vehicleOdometer);
        Assert.assertTrue(Integer.parseInt(vehicleOdometer) >= 0, "Unable to validate Km range");
        LogReporter.Reporter("validated display odometer greater than equal to 0");
    }
    public FleetTrackingScreenV1 VehicleRealTimeDetails() {
        Assert.assertTrue(actions.iselementVisible(vehicleCurrentStatus));
        LogReporter.Reporter("Vehicle Current Status displayed");
        vehicleCurrentStatus.click();
        LogReporter.Reporter("Vehicle Current Status Clicked");
        ScreenShotUtils.attachScreenshot();
        String displayVehicleSpeed = vehicleRealTimeSpeed.getText();
        Assert.assertTrue(displayVehicleSpeed.toLowerCase().contains("km/h"), "Unable to validate Km/H in Display");
        displayVehicleSpeed = displayVehicleSpeed.toLowerCase().replace("km/hr", " ").trim();
        LogReporter.Reporter("The value of vehicles real time speed in Integer " + displayVehicleSpeed);
        Assert.assertTrue(Integer.parseInt(displayVehicleSpeed) >= 0, "Unable to validate Km/H");
        LogReporter.Reporter("Validated display vehicle real time speed greater than equal to 0");
        String displayVehicleLocation = vehicleRealTimeLocation.getText();
        LogReporter.Reporter("Vehicle Location displayed is" + displayVehicleLocation);
        Assert.assertTrue(displayVehicleLocation.toLowerCase().contains("current"), "Unable to validate Current location in Display ");
        displayVehicleLocation = displayVehicleLocation.toLowerCase().replace("current", " ")
                .replace(" ", "");
        LogReporter.Reporter("Validated display vehicle current " + displayVehicleLocation);
        String displayVehicleLastUpdate = vehicleRealTimeLastUpdated.getText();
        Assert.assertTrue(displayVehicleLastUpdate.toLowerCase().contains("last"), "Unable to validate last updated status in Display ");
        displayVehicleLastUpdate = displayVehicleLastUpdate.toLowerCase().replace("last", " ")
                .replace("Updated:", "").trim();
        LogReporter.Reporter("Validated display vehicle Last " + displayVehicleLastUpdate);
        return this;
    }


    public void validateOneVehicleDetailsCategories() {
        boolean android = driver.getCapabilities().getPlatformName().toString().equalsIgnoreCase(Platform.ANDROID.toString());
        vehicleCurrentStatus.click();
        ScreenShotUtils.attachScreenshot();
        Assert.assertTrue(android == true ? vehicleCurrentStatus.isDisplayed() : vehicleCurrentStatus.isEnabled(), "Vehicle current status Categories not display");
        LogReporter.Reporter("Vehicle current status is display");
        if (driver.getCapabilities().getPlatformName().toString().contains(Platform.ANDROID.toString())) {
            Assert.assertTrue(actions.iselementVisible(vehiclePlayBackAndTrace));
        }
        vehiclePlayBackAndTrace.click();
        ScreenShotUtils.attachScreenshot();
        Assert.assertTrue(android == true ? actions.waitforElementVisible(filteronPlaybackAndtrace, 5).isDisplayed() : vehiclePlayBackAndTrace.isEnabled(), "Vehicle playback and trace Categories not display");
        LogReporter.Reporter("Vehicle PlayBackAndTrace is display");
        vehicleQuickLinks.click();
        ScreenShotUtils.attachScreenshot();
        Assert.assertTrue(android == true ? actions.waitforElementVisible(qlVehicleDetails, 5).isDisplayed() : vehicleQuickLinks.isEnabled(), "Vehicle quick links Categories not display");
        LogReporter.Reporter("Vehicle QuickLinks is display");
        navigateToHome();
    }

    public FleetTrackingScreenV1 validateOneVehicleDetails() {
        navigateToFleetTracking();
        waitForAndroidProgresBar(1);
        swichTrackingView(TrackingView.List);
        LogReporter.Reporter("All vehicle are showing in list view");
        vehicleRegNo.click();
        LogReporter.Reporter("Selected one vehicle from list view");
        LogReporter.Reporter("Looking for header");
        String regNoOfVehicleDetailsPage = verifyVehicleRegNo.getText();
        storedVehicleNumber = regNoOfVehicleDetailsPage;
        Assert.assertTrue(verifyVehicleRegNo.isDisplayed(), "Vehicle Registration number is not Displayed");
        LogReporter.Reporter("Verified with vehicle Registration number: " + regNoOfVehicleDetailsPage);
        ScreenShotUtils.attachScreenshot();
        return this;
    }

    public void navigateHomeToListView() {
        navigateToHome();
        navigateToFleetTracking();
        waitForAndroidProgresBar(1);
        swichTrackingView(TrackingView.List);
    }

    public void validateVehicleReadings() {
        navigateToFleetTracking();
        waitForAndroidProgresBar(1);
        swichTrackingView(TrackingView.List);
        LogReporter.Reporter("All vehicle are showing in list view");
        movingButton.click();
        LogReporter.Reporter("Selected moving tab");
        ScreenShotUtils.attachScreenshot();
        validateAllReadingsUnderTab();
        navigateHomeToListView();
        idlingButton.click();
        LogReporter.Reporter("Selected idling tab");
        ScreenShotUtils.attachScreenshot();
        validateAllReadingsUnderTab();
        navigateHomeToListView();
        stoppedButton.click();
        LogReporter.Reporter("Selected stopped tab");
        ScreenShotUtils.attachScreenshot();
        validateAllReadingsUnderTab();
        navigateHomeToListView();
        notReachableButton.click();
        LogReporter.Reporter("Selected not-Reachable tab");
        ScreenShotUtils.attachScreenshot();
        validateAllReadingsUnderTab();
        navigateToHome();
    }

    public void validateAllReadingsUnderTab() {
        validateOdometer(vehicleOdometer);
        validateFuelLevels(vehicleFuelLevel);
        validateLastUpdated(vehicleLastUpdated);
        validateVehicleHealth(vehicleHealth);
    }


    public void validateOdometer(List<WebElement> elements) {
        for (WebElement element : elements) {
            String displayOdometer = element.getText();
            LogReporter.Reporter("The value of vehicles odometer is " + displayOdometer);
            Assert.assertTrue(displayOdometer.toLowerCase().contains("kms"), "Unable to validate Km in Display odometer");
            displayOdometer = displayOdometer.toLowerCase().replace(",", "")
                    .replace("kms", "")
                    .replace(" ", "").trim();
            LogReporter.Reporter("The value of vehicles odometer in Integer " + displayOdometer);

            Assert.assertTrue(Integer.parseInt(displayOdometer) >= 0, "Unable to validate Km range");
            LogReporter.Reporter("validated display odometer greater  equal to 0");
        }


    }

    public void validateFuelLevels(List<WebElement> elements) {
        for (WebElement element : elements) {
            String displayFuelLevels = element.getText();
            LogReporter.Reporter("The value of vehicles Fuel level is " + displayFuelLevels);
            Assert.assertTrue(displayFuelLevels.toLowerCase().contains("l"), "Unable to validate l in Display Fuel levels");
            displayFuelLevels = displayFuelLevels.toLowerCase()
                    .replace(" ", "")
                    .replace("l", "").trim();
            LogReporter.Reporter("The value of vehicles fuel level in Integer " + displayFuelLevels);
            Assert.assertTrue(Integer.parseInt(displayFuelLevels) >= 0, "Unable to validate l ");
            LogReporter.Reporter("validated display fuel level greater than equal to 0");
        }
    }
    public void validateLastUpdated(List<WebElement> elements) {
        for (WebElement element : elements) {
            String displayLastUpdated = element.getText();
            LogReporter.Reporter("The value of last updated time is " + displayLastUpdated);
            boolean datetime = false;

            if (displayLastUpdated.toLowerCase().contains("pm") || displayLastUpdated.toLowerCase().contains("am")) {
                datetime = true;
            }
            Assert.assertTrue(datetime, "Unable to validate am/pm in Display last updated");
            displayLastUpdated = displayLastUpdated.toLowerCase()
                    .replace(" ", "");
            LogReporter.Reporter("The value of vehicles last Updated  " + displayLastUpdated);
        }

    }

    public void validateVehicleHealth(List<WebElement> elements) {
        for (WebElement element : elements) {
            String displayVehicleHealth = element.getText();
            LogReporter.Reporter("The value of vehicles health is " + displayVehicleHealth);
            Assert.assertNotEquals(displayVehicleHealth, "", "Unable to validate vehicle health in Display ");
        }
    }

    public FleetTrackingScreenV1 goToOurServices() {
        Assert.assertTrue(actions.iselementVisible(ourServicesMenuOption), "Our services options is not visible");
        ourServicesMenuOption.click();
        LogReporter.Reporter("User is on Our services menu ");
        goToFleetTrackingScreen();
        return this;
    }

    public void goToFleetTrackingScreen() {
        Assert.assertTrue(actions.iselementVisible(fleetTrackingOption), "Fleet Tracking options not visible ");
        fleetTrackingOption.click();
        LogReporter.Reporter("Clicked on Fleet Tracking option");
        Assert.assertTrue(actions.iselementVisible(trackOption), "Track option is not visible");
        trackOption.click();
        LogReporter.Reporter("Clicked on Track option");
    }

    public void validateStatusAndValues() {
        Assert.assertTrue(actions.iselementVisible(fleetTrackingTitle));
        waitForAndroidProgresBar(1);
        Assert.assertTrue(movingStatus.isEnabled());
        Assert.assertTrue(stoppedStatus.isEnabled());
        Assert.assertTrue(notReachableStatus.isEnabled());
        Assert.assertTrue(idleStatus.isEnabled());
        LogReporter.Reporter("Moving Vehicle :" + movingValue.getText());
        LogReporter.Reporter("Stopped Vehicle : " + stoppedValue.getText());
        LogReporter.Reporter("Not Reachable Vehicle :" + notReachableValue.getText());
        LogReporter.Reporter("idle Vehicle :" + idleValue.getText());
        ScreenShotUtils.attachScreenshot();
        navigateToHome();
    }
    public FleetTrackingScreenV1 validateMovingCategory() {
        navigateToFleetTracking();
        waitForAndroidProgresBar(1);
       // swichTrackingView(TrackingView.List);
        movingButton.click();
        LogReporter.Reporter("Clicked on Moving Button");
        ScreenShotUtils.attachScreenshot();
        String mValue = movingValue.getText();
        LogReporter.Reporter("Moving Vehicle :" + mValue);
        Assert.assertTrue(actions.iselementVisible(movingButton, 2), "Moving button not visible");
        navigateToHome();
        return this;
    }

    public FleetTrackingScreenV1 validateIdleCategory() {
        navigateToFleetTracking();
        waitForAndroidProgresBar(1);
       // swichTrackingView(TrackingView.List);
        idlingButton.click();
        ScreenShotUtils.attachScreenshot();
        String iValue = idleValue.getText();
        LogReporter.Reporter("idling Vehicle :" + iValue);
        Assert.assertTrue(actions.iselementVisible(idlingButton, 2), "idling button not visible");
        navigateToHome();
        return this;
    }

    public FleetTrackingScreenV1 validateStoppedCategory() {
        navigateToFleetTracking();
        waitForAndroidProgresBar(1);
      //  swichTrackingView(TrackingView.List);
        stoppedButton.click();
        ScreenShotUtils.attachScreenshot();
        LogReporter.Reporter("Clicked on stoppedButton");
        String sValue = stoppedValue.getText();
        LogReporter.Reporter("Stopped Vehicle :" + sValue);
        Assert.assertTrue(actions.iselementVisible(stoppedButton, 2), "Stopped button not visible");
        navigateToHome();
        return this;
    }


    public FleetTrackingScreenV1 navigateToHome() {
        Assert.assertTrue(actions.iselementVisible(homeMenu, 2));
        LogReporter.Reporter("Home Menu is visible");
        homeMenu.click();
        LogReporter.Reporter("Clicked on Home Menu");
        waitForAndroidProgresBar(1);
        if (actions.iselementVisibleforMilli(homeMenuTitle, 300, true)) {
            LogReporter.Reporter("Validated Home Menu Title");
        } else {
            Assert.assertTrue(actions.iselementVisible(homeMenuTitle, 2));
            homeMenu.click();
            LogReporter.Reporter("Re Clicked on Home Menu");

        }
        ScreenShotUtils.attachScreenshot();
        return this;
    }

    public FleetTrackingScreenV1 swichTrackingView(TrackingView view) {
        switch (view) {

            case List:
                Assert.assertTrue(actions.iselementVisible(listView,5), "View is already selected List View - Unable to change again");
                listView.click();
                Assert.assertTrue(actions.iselementVisible(listLayout));
                LogReporter.Reporter("Switched to List menu");
                ScreenShotUtils.attachScreenshot();
                break;
            case Map:
                Assert.assertTrue(actions.iselementVisible(mapView), "View is already selected Map View - Unable to change again");
                mapView.click();
                Assert.assertTrue(actions.iselementVisible(mapLayout));
                LogReporter.Reporter("Switched to Map view");
                ScreenShotUtils.attachScreenshot();
                break;
        }
        return this;
    }

    public FleetTrackingScreenV1 validateNotReachable() {
        navigateToFleetTracking();
        waitForAndroidProgresBar(1);
       // swichTrackingView(TrackingView.List);
        notReachableButton.click();
        ScreenShotUtils.attachScreenshot();
        String nrValue = notReachableValue.getText();
        LogReporter.Reporter("Not Reachable Vehicle :" + nrValue);
        Assert.assertTrue(actions.iselementVisible(notReachableButton, 2), "Not Reachable button not visible");
        navigateToHome();
        return this;
    }

    public void selectCategories() {
        navigateToFleetTracking();
        waitForAndroidProgresBar(1);
        swichTrackingView(TrackingView.Map);
        movingButton.click();
        LogReporter.Reporter("Clicked on Moving Button");
        ScreenShotUtils.attachScreenshot();
        Assert.assertTrue(isCategorySelected("Moving"));
        idlingButton.click();
        LogReporter.Reporter("Clicked on Idling Button");
        Assert.assertTrue(isCategorySelected("Idling"));
        ScreenShotUtils.attachScreenshot();
        stoppedButton.click();
        LogReporter.Reporter("Clicked on stopped Button");
        Assert.assertTrue(isCategorySelected("Stopped"));
        ScreenShotUtils.attachScreenshot();
        notReachableButton.click();
        LogReporter.Reporter("Clicked on not Reachable Button");
        Assert.assertFalse(isCategorySelected("Not Reachable"));
        ScreenShotUtils.attachScreenshot();
        navigateToHome();
    }
    public Boolean isCategorySelected(String category) {
        String xpath;
        boolean flag = false;
        if (driver.getCapabilities().getPlatformName().toString().equalsIgnoreCase(Platform.ANDROID.toString().toLowerCase())) {
            category = category.toLowerCase().contains("not") ? "non_communicable" : category.toLowerCase();
            xpath = "//*[@resource-id=\"in.here.volvo.android:id/ll_" + category + "\"]/android.view.View";
        } else {
            xpath = "//XCUIElementTypeOther/XCUIElementTypeStaticText[@label =\"" + category + "\"]/following-sibling::XCUIElementTypeOther";
        }
        try {
            flag = actions.waitForElementByXpath(xpath).isEnabled();
        } catch (Exception ex) {
            LogReporter.Reporter("Element not Present for locator" + xpath);
        }
        return flag;
    }

    public void openDetailedVehicleMap() {
        navigateToFleetTracking();
        waitForAndroidProgresBar(1);
        String vehicleRegistrationDetails = individualVehicleOnMap.get(0).getAttribute("content-desc");
        LogReporter.Reporter("Individual Vehicle Registration Number" + vehicleRegistrationDetails);
        individualVehicleOnMap.get(0).click();
        LogReporter.Reporter("Clicking On" + vehicleRegistrationDetails);
        ScreenShotUtils.attachScreenshot();
        Assert.assertTrue(actions.iselementVisible(vehicleCurrentStatus));
        LogReporter.Reporter("Open Detailed view for vehicle" + detailedViewHeader.getText());
        Assert.assertTrue(vehicleRegistrationDetails.contains(detailedViewHeader.getText().trim()));
        LogReporter.Reporter("Validated Detailed view open for" + vehicleRegistrationDetails);
        navigateToHome();
    }

    public void openClusterVehicleMap() {
        navigateToFleetTracking();
        waitForAndroidProgresBar(1);
        vehicleClusters.get(0).click();
        LogReporter.Reporter("Clicking On vehicle cluster");
        ScreenShotUtils.attachScreenshot();
        Assert.assertTrue(actions.iselementVisible(vehicleCountGridHeader));
        LogReporter.Reporter("Available  vehicles in clusters :" + vehicleCountGridHeader.getText());
        closeBottomSheet.click();
        navigateToHome();
    }

    public void categorySwitchViewByVehicle() {
        navigateToFleetTracking();
        waitForAndroidProgresBar(1);
        swichTrackingView(TrackingView.Map);
        swichTrackingView(TrackingView.List);
        listviewFilter.click();
        ScreenShotUtils.attachScreenshot();
        LogReporter.Reporter("Clicked on List View filter option");
        viewByVehicle.click();
        ScreenShotUtils.attachScreenshot();
        LogReporter.Reporter("Clicked on view by vehicle");
        String vehicle = vehiclesList.get(0).getText();
        LogReporter.Reporter("First vehicle is " + vehicle);
        vehiclesList.get(0).click();
        ScreenShotUtils.attachScreenshot();
        LogReporter.Reporter("Clicked and selected vehicle " + vehicle);
        doneBottomSHeet.click();
        ScreenShotUtils.attachScreenshot();
        LogReporter.Reporter("Clicked on done button ");
        if (driver.getCapabilities().getPlatformName().toString().equalsIgnoreCase(Platform.ANDROID.toString())) {
            String selected = selectedVehicle.getText();
            Assert.assertTrue(selected.contains(vehicle), "vehicle " + selected + " and " + vehicle + " are not same");
        }
        Assert.assertTrue(actions.iselementVisible(applyFilter));
        LogReporter.Reporter("Validated apply filter");
        try {
            applyFilter.click();
        } catch (Exception ex) {
            LogReporter.INFO(ex.getMessage());
        }
        LogReporter.Reporter("Clicked on apply filter");
        actions.iselemenDisappeared(applyFilter, 1);
        LogReporter.Reporter("waited for bottomSheet disappear");
        ScreenShotUtils.attachScreenshot();
        swichTrackingView(TrackingView.Map);
        if (driver.getCapabilities().getPlatformName().toString().equalsIgnoreCase(Platform.ANDROID.toString())) {

            Assert.assertEquals(individualVehicleOnMap.size(), 1);
            String vehicleRegistrationDetails = individualVehicleOnMap.get(0).getAttribute("content-desc");
            LogReporter.Reporter("Individual Vehicle Registration Number" + vehicleRegistrationDetails);
            Assert.assertTrue(vehicleRegistrationDetails.contains(vehicle));
        }
        ScreenShotUtils.attachScreenshot();
        navigateToHome();
    }

    public void filterViewByVehicle() {
        navigateToFleetTracking();
        waitForAndroidProgresBar(1);
        Assert.assertTrue(actions.iselementVisible(searchButton));
        LogReporter.Reporter("validated search button available");
        actions.iselementVisible(listView);
        searchButton.click();
        LogReporter.Reporter("Search Button Clicked");
        Assert.assertTrue(actions.iselementVisible(filterByVehicle));
        LogReporter.Reporter("Filter by Vehicle Available");
        Assert.assertTrue(actions.iselementVisible(filterByLocation));
        LogReporter.Reporter("Filter by Location Available");
        ScreenShotUtils.attachScreenshot();
        viewByVehicle.click();
        String vehicle = vehiclesList.get(0).getText();
        vehiclesList.get(0).click();
        doneButton.click();
        ScreenShotUtils.attachScreenshot();
        String selected = selectedVehicle.getText();
        Assert.assertTrue(selected.contains(vehicle), "vehicle " + selected + " and " + vehicle + " are not same");
        applyFilter.click();
        ScreenShotUtils.attachScreenshot();
        Assert.assertEquals(individualVehicleOnMap.size(), 1);
        String vehicleRegistrationDetails = individualVehicleOnMap.get(0).getAttribute("content-desc");
        LogReporter.Reporter("Individual Vehicle Registration Number" + vehicleRegistrationDetails);
        Assert.assertTrue(vehicleRegistrationDetails.contains(selected));
        navigateToHome();
    }

    public void filterViewByLocation() {
        navigateToFleetTracking();
        waitForAndroidProgresBar(1);
        swichTrackingView(TrackingView.List);
        String addresstext = address.get(0).getText();
        swichTrackingView(TrackingView.Map);
        Assert.assertTrue(actions.iselementVisible(searchButton));
        searchButton.click();
        Assert.assertTrue(actions.iselementVisible(filterByVehicle));
        Assert.assertTrue(actions.iselementVisible(filterByLocation));
        filterByLocation.click();
        ScreenShotUtils.attachScreenshot();
        sendKeys(locationSearchBar, addresstext);
        LogReporter.Reporter("Location is" + vehiclesList.get(0).getText());
        vehiclesList.get(0).click();
        try {
            applyFilter.click();
        } catch (Exception ex) {

        }
        ScreenShotUtils.attachScreenshot();
        swichTrackingView(TrackingView.List);
        for (WebElement vehicleLocation : address) {
            LogReporter.Reporter(vehicleLocation.getText());
        }
        navigateToHome();
    }

}
