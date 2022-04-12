package hello.itemservice.web.validation.form;

import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class ItemUpdateForm {

    @NotNull
    private Long id;

    @NotBlank
    private String itemName;

    @NotNull
    @Range(min = 1000, max = 10000000)
    private  Integer price;

    //수정에는 수량을 자유롭게 변경 가능.
    private Integer quantity;

}
