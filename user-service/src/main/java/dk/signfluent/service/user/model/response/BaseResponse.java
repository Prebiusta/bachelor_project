package dk.signfluent.service.user.model.response;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BaseResponse {
    private String message;
    private boolean successful;

    public void setSuccessfulResponse() {
        this.message = "Success";
        this.successful = true;
    }

    public static BaseResponse createSuccessful() {
        return new BaseResponse("Success", true);
    }

    public static BaseResponse createFailed(String message) {
        return new BaseResponse(message, false);
    }
}
