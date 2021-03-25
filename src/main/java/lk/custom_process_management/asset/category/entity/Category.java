package lk.custom_process_management.asset.category.entity;



import com.fasterxml.jackson.annotation.JsonFilter;
import lk.custom_process_management.asset.common_asset.model.enums.LiveDead;
import lk.custom_process_management.asset.item.entity.enums.MainCategory;
import lk.custom_process_management.asset.item.entity.Item;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonFilter("Category")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Size(min = 3, message = "Your name cannot be accepted")
    private String name;

    @Enumerated(EnumType.STRING)
    private MainCategory mainCategory;

    @Enumerated( EnumType.STRING )
    private LiveDead liveDead;

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List< Item > items;
}
