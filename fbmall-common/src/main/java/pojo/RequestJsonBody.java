package pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RequestJsonBody implements Serializable {
    private Integer number;
    private String string;
    private Object data;
    private Object extra;
}
