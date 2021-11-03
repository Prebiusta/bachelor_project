package dk.signfluent.service.user.model.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BaseResponse {
    private String message;
    private boolean successful;

    public static BaseResponse createSuccessful() {
        return new BaseResponse("Success", true);
    }

    public static BaseResponse createFailed(String message) {
        return new BaseResponse(message, false);
    }

    public void setSuccessfulResponse() {
        this.message = "Success";
        this.successful = true;
    }
}
