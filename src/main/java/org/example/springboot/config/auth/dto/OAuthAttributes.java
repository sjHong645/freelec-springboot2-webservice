package org.example.springboot.config.auth.dto;

import java.util.Map;

import lombok.Builder;
import lombok.Getter;
import org.example.springboot.domain.user.Role;
import org.example.springboot.domain.user.User;

@Getter
public class OAuthAttributes {

    private Map<String, Object> attributes;
    private String nameAttributesKey;
    private String name;
    private String email;
    private String picture;

    @Builder
    public OAuthAttributes(Map<String, Object> attributes, String nameAttributesKey
                          ,String name, String email, String picture) {

        this.attributes = attributes;
        this.nameAttributesKey = nameAttributesKey;
        this.name = name;
        this.email = email;
        this.picture = picture;

    }

    public static OAuthAttributes of(String registrationId, String userNameAttributeName,
                                     Map<String, Object> attributes) {

        return ofGoogle(userNameAttributeName, attributes);

    }

    public static OAuthAttributes ofGoogle(String userNameAttributeName, Map<String, Object> attributes) {

        return OAuthAttributes.builder()
                .name((String) attributes.get("name"))
                .email((String) attributes.get("email"))
                .picture((String) attributes.get("picture"))
                .attributes(attributes)
                .nameAttributesKey(userNameAttributeName)
                .build();
    }

    public User toEntity() {

        return User.builder()
                .name(name)
                .email(email)
                .picture(picture)
                .role(Role.GUEST)
                .build();

    }


}
