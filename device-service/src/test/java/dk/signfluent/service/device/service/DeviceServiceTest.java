package dk.signfluent.service.device.service;

import dk.signfluent.service.device.entity.DeviceEntity;
import dk.signfluent.service.device.mapper.DeviceMapper;
import dk.signfluent.service.device.model.Device;
import dk.signfluent.service.device.model.DeviceServiceException;
import dk.signfluent.service.device.model.request.RegisterDeviceRequest;
import dk.signfluent.service.device.model.request.UpdateFCMTokenRequest;
import dk.signfluent.service.device.model.response.RegisterDeviceResponse;
import dk.signfluent.service.device.model.response.UpdateFCMTokenResponse;
import dk.signfluent.service.device.repository.DeviceRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mapstruct.factory.Mappers;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.*;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class DeviceServiceTest {
    private static final String TEST_FCM_TOKEN = "testFCMToken";
    private static final UUID TEST_UUID = UUID.randomUUID();
    private static final String TEST_HARDWARE_ID = "testHardwareId";

    private final DeviceMapper deviceMapper = Mappers.getMapper(DeviceMapper.class);
    private DeviceService deviceService;

    @Mock
    private DeviceRepository deviceRepository;

    @Before
    public void setUp() {
        deviceService = new DeviceService(deviceRepository, deviceMapper);
    }

    @Test
    public void testEntityMapping() {
        int numberOfDevicesToGenerate = 10;
        returnListWhenGetDevicesForUser(numberOfDevicesToGenerate);

        List<Device> devicesForUser = deviceService.getDevicesForUser(UUID.randomUUID());

        DeviceEntity testDeviceEntity = createTestDeviceEntity();
        devicesForUser.forEach(device -> {
            assertEquals(device.getDeviceHardwareId(), testDeviceEntity.getDeviceHardwareId());
            assertEquals(device.getUserId(), testDeviceEntity.getUserId());
            assertEquals(device.getFCMToken(), testDeviceEntity.getFCMToken());
            assertEquals(device.getId(), testDeviceEntity.getId());
        });
    }

    @Test
    public void testGetDevicesForUserMultiple() {
        int numberOfDevicesToGenerate = 4;
        returnListWhenGetDevicesForUser(numberOfDevicesToGenerate);

        List<Device> devicesForUser = deviceService.getDevicesForUser(UUID.randomUUID());

        assertEquals(numberOfDevicesToGenerate, devicesForUser.size());
    }

    @Test
    public void testGetDevicesForUserEmpty() {
        returnEmptyListWhenGetDevicesForUser();

        List<Device> devicesForUser = deviceService.getDevicesForUser(UUID.randomUUID());

        assertEquals(0, devicesForUser.size());
    }

    @Test
    public void testRegisterDeviceUnique() {
        returnEmptyListWhenGetDevicesForUser();
        returnTestDeviceEntityWhenSave();

        RegisterDeviceResponse registerDeviceResponse = deviceService.registerDevice(createTestRegisterDeviceRequest());

        assertEquals(TEST_HARDWARE_ID, registerDeviceResponse.getDeviceEntity().getDeviceHardwareId());
        assertEquals(TEST_UUID, registerDeviceResponse.getDeviceEntity().getUserId());
    }

    @Test(expected = DeviceServiceException.class)
    public void testRegisterDeviceMissingHardwareId() {
        RegisterDeviceRequest request = new RegisterDeviceRequest();
        request.setUserId(TEST_UUID);

       deviceService.registerDevice(request);
    }

    @Test(expected = DeviceServiceException.class)
    public void testRegisterDeviceMissingUserId() {
        RegisterDeviceRequest request = new RegisterDeviceRequest();
        request.setDeviceHardwareId(TEST_HARDWARE_ID);

        deviceService.registerDevice(request);
    }

    @Test(expected = DeviceServiceException.class)
    public void testRegisterDeviceExisting() {
        returnListWhenGetDevicesForUser(1);

        deviceService.registerDevice(createTestRegisterDeviceRequest());
    }

    @Test(expected = DeviceServiceException.class)
    public void testUpdateFCMTokenNonExistingDevice() {
        returnEmptyWhenFindByHardwareIdAndUserId();

        deviceService.updateFCMToken(createTestFCMTokenUpdateRequest());
    }

    @Test
    public void testUpdateFCMToken() {
        returnTestDeviceEntityWhenFindByHardwareIdAndUserId();
        returnTestDeviceEntityWhenSave();

        UpdateFCMTokenResponse updateFCMTokenResponse = deviceService.updateFCMToken(createTestFCMTokenUpdateRequest());

        assertEquals(TEST_FCM_TOKEN, updateFCMTokenResponse.getDeviceEntity().getFCMToken());
    }

    private void returnTestDeviceEntityWhenFindByHardwareIdAndUserId() {
        when(deviceRepository.findFirstByDeviceHardwareIdAndUserId(any(), any())).thenReturn(Optional.of(createTestDeviceEntity()));
    }

    private void returnEmptyWhenFindByHardwareIdAndUserId() {
        when(deviceRepository.findFirstByDeviceHardwareIdAndUserId(any(), any())).thenReturn(Optional.empty());
    }

    private void returnEmptyListWhenGetDevicesForUser() {
        when(deviceRepository.findAllByUserId(any())).thenReturn(Collections.emptyList());
    }

    private void returnTestDeviceEntityWhenSave() {
        when(deviceRepository.save(any())).thenReturn(createTestDeviceEntity());
    }

    private void returnListWhenGetDevicesForUser(int numberOfDevicesToGenerate) {
        when(deviceRepository.findAllByUserId(any())).thenReturn(creatTestDeviceEntityList(numberOfDevicesToGenerate));
    }

    private UpdateFCMTokenRequest createTestFCMTokenUpdateRequest() {
        UpdateFCMTokenRequest request = new UpdateFCMTokenRequest();
        request.setFcmToken(TEST_FCM_TOKEN);
        request.setDeviceHardwareId(TEST_HARDWARE_ID);
        request.setUserId(TEST_UUID);
        return request;
    }

    private List<DeviceEntity> creatTestDeviceEntityList(int numberOfDevicesToGenerate) {
        List<DeviceEntity> deviceEntities = new ArrayList<>();
        for (int i = 0; i < numberOfDevicesToGenerate; i++) {
            deviceEntities.add(createTestDeviceEntity());
        }
        return deviceEntities;
    }

    private DeviceEntity createTestDeviceEntity() {
        DeviceEntity deviceEntity = new DeviceEntity();
        deviceEntity.setFCMToken(TEST_FCM_TOKEN);
        deviceEntity.setDeviceHardwareId(TEST_HARDWARE_ID);
        deviceEntity.setUserId(TEST_UUID);
        deviceEntity.setId(TEST_UUID);
        return deviceEntity;
    }

    private RegisterDeviceRequest createTestRegisterDeviceRequest() {
        RegisterDeviceRequest registerDeviceRequest = new RegisterDeviceRequest();
        registerDeviceRequest.setDeviceHardwareId(TEST_HARDWARE_ID);
        registerDeviceRequest.setUserId(TEST_UUID);
        return registerDeviceRequest;
    }
}