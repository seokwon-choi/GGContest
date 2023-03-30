package digico.com.GGcontestb.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Accessors(chain = true)
public class Response<T> {

    @JsonProperty("common")
    private Common common;

    @JsonProperty("data")
    private T data;


    
    @JsonIgnore
    public Response<T> responseOk() {
        return (Response<T>) Response.builder()
                .common(Common.builder().build().responseOk())
                .build();
    }

    @JsonIgnore
    public Response<T> responseOk(T value) {
        return (Response<T>) Response.builder()
                .data(Value.builder().build().responseOk(value))
                .common(Common.builder().build().responseOk())
                .build();
    }

    @JsonIgnore
    public Response<T> responseOk(T value, Pagination pagination) {

        return (Response<T>) Response.builder()
                .data(Value.builder().build().responseOk(value, pagination))
                .common(Common.builder().build().responseOk())
                .build();
    }

    @JsonIgnore
    public Response<T> validationError(StatusEnum status) {
        return (Response<T>) Response.builder()
                .common(Common.builder().build().validationError(status))
                .build();
    }

    @JsonIgnore
    public Response<T> serverError(StatusEnum status) {
        return (Response<T>) Response.builder()
                .common(Common.builder().build().serverError(status))
                .build();
    }

    @JsonIgnore
    public Response<T> serverError(int code, String message) {
        return (Response<T>) Response.builder()
                .common(Common.builder().build().serverError(code, message))
                .build();
    }

}
