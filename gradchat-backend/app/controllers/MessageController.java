package controllers;

import com.google.inject.Inject;
import dto.MessageDto;
import dto.UserDto;
import play.libs.Json;
import play.mvc.BodyParser;
import play.mvc.Controller;
import play.mvc.Result;
import services.MessageService;
import utilities.JsonMapper;

import java.io.IOException;

public class MessageController extends Controller {
    @Inject
    MessageService messageService;

    @BodyParser.Of(BodyParser.Json.class)
    public Result createMessage(){
        MessageDto messageDto = null;
        String requestParams = request().body().asJson().toString();
        try {
            messageDto = JsonMapper.mapJson(requestParams, MessageDto.class);
            messageService.createMessage(messageDto);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ok(Json.toJson(messageDto));
    }
    @BodyParser.Of(BodyParser.Json.class)
    public Result getMessages(){
        MessageDto messageDto = null;
        String requestParams = request().body().asJson().toString();
        try {
            messageDto = JsonMapper.mapJson(requestParams, MessageDto.class);
            return ok(Json.toJson(messageService.getMessages(messageDto)));
        } catch (IOException e) {
            System.out.println(e.getLocalizedMessage());
        }
        return ok("No Messages To Display...");
    }
}
