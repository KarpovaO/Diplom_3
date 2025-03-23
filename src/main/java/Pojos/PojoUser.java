package Pojos;
import lombok.*;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class PojoUser {
    @NonNull
    private String name;
    @NonNull
    private String email;
    @NonNull
    private String password;

    private String accessToken;
    private String refreshToken;
    private String authorization;

}
