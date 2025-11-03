package umc.demo.domain.food;

import jakarta.persistence.*;
import lombok.*;
import umc.demo.domain.member.MemberFood;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class Food {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private int price;
    private String imageUrl;


    @OneToMany(mappedBy = "food", cascade = CascadeType.ALL)
    private List<MemberFood> memberFoods = new ArrayList<>();
}
