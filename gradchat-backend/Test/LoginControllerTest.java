import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.google.gson.JsonObject;
import controllers.LoginController;
import dto.UserDto;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.mockito.internal.util.reflection.Whitebox;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.testng.Assert;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Http;
import play.mvc.Http.Request;
import play.mvc.Http.RequestBody;
import play.mvc.Result;
import services.UserManagementService;
import utilities.JsonMapper;

import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static play.test.Helpers.contentAsString;

@RunWith(PowerMockRunner.class)
@PrepareForTest({Controller.class, Http.RequestBody.class, JsonMapper.class, Json.class})
public class LoginControllerTest {
    private UserManagementService userManagementService;
    private UserDto userDto;
    private LoginController loginController;
    private Http.Request request;
    private Http.RequestBody requestBody;
    private ObjectNode parametersNode;
    @Before
    public void setUp(){
        userManagementService = mock(UserManagementService.class);
        request = mock(Http.Request.class);
        requestBody = PowerMockito.mock(Http.RequestBody.class);
        userDto = new UserDto();
        userDto.setUserFirstName("Sameera");
        userDto.setUserId((long) 1);
        userDto.setUserLastName("Piyasundara");
        userDto.setUserEmail("madumal.piyasundara@gmail.com");
        userDto.setUserPassword("$@m");
        loginController = new LoginController();
        Whitebox.setInternalState(loginController, "userManagementService", userManagementService);
        parametersNode = Json.newObject();
        parametersNode.put("USER_ID", 1);
        parametersNode.put("USER_FIRSTNAME", "Sameera");
        parametersNode.put("USER_LASTNAME", "Piyasundara");
        parametersNode.put("USER_EMAIL", "madumal.piyasundara@gmail.com");
        parametersNode.put("USER_PASSWORD", "$@m");
    }

    @Test
    public void should_successfully_create_a_user() throws IOException {
        String successString = "{\"USER_ID\":1,\"USER_FIRSTNAME\":\"Sameera\",\"USER_LASTNAME\":\"Piyasundara\",\"USER_EMAIL\":\"madumal.piyasundara@gmail.com\",\"USER_PASSWORD\":\"$@m\"}";

        PowerMockito.mockStatic(Controller.class);
        BDDMockito.given(Controller.request()).willReturn(request);
        BDDMockito.given(request.body()).willReturn(requestBody);
        when(requestBody.asJson()).thenReturn(parametersNode);
        PowerMockito.mockStatic(JsonMapper.class);
        BDDMockito.given(JsonMapper.mapJson(parametersNode.toString(), UserDto.class)).willReturn(userDto);
        doNothing().when(userManagementService).createUser(userDto);
        Result actualResult = loginController.createUser();
        assertEquals(contentAsString(actualResult), successString);
    }

    @Test(expected = IOException.class)
    public void should_fail_the_process_of_creating_a_user_when_throwing_an_IO_exception() throws IOException {
        PowerMockito.mockStatic(Controller.class);
        BDDMockito.given(Controller.request()).willReturn(request);
        BDDMockito.given(request.body()).willReturn(requestBody);
        when(requestBody.asJson()).thenReturn(parametersNode);
        PowerMockito.mockStatic(JsonMapper.class);
        BDDMockito.given(JsonMapper.mapJson(parametersNode.toString(), UserDto.class)).willThrow(IOException.class);
        Result actualResult = loginController.createUser();
    }


}
