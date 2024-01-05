//package cotato.hackathon.domain.user.vo;
//
//
//import ceos.backend.domain.user.domain.User;
//import ceos.backend.domain.user.domain.UserRole;
//import ceos.backend.global.common.entity.Part;
//import lombok.Builder;
//import lombok.Getter;
//
//@Getter
//public class UserBriefInfoVo {
//
//    private Long id;
//    private String name;
//    private Part part;
//    private String email;
//    private UserRole userRole;
//
//    @Builder
//    private UserBriefInfoVo(Long id, String name, Part part, String email, UserRole userRole) {
//        this.id = id;
//        this.name = name;
//        this.part = part;
//        this.email = email;
//        this.userRole = userRole;
//    }
//
//    public static UserBriefInfoVo from(User user) {
//        return UserBriefInfoVo.builder()
//                .id(user.getId())
//                .name(user.getName())
//                .part(user.getPart())
//                .email(user.getEmail())
//                .userRole(user.getRole())
//                .build();
//    }
//}
