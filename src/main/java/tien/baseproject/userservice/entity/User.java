package tien.baseproject.userservice.entity;

import lombok.*;
import lombok.experimental.SuperBuilder;
import tien.baseproject.userservice.constant.RoleTypeEnum;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "\"user\"", schema = "public")
@Getter
@Setter
@SuperBuilder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class User extends BaseEntity{
    @Column(name = "username")
    private String username;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "role_type")
    @Builder.Default
    private Integer roleType = RoleTypeEnum.END_USER.getCode();
}
