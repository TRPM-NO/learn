package web.noname.service.domain.item;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ItemCode {
    private String code;
    private String displayName;
}
