package uz.uniquecode.servicea.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Author: Abbos Fayziboev
 * Date: 14/04/23
 * Email: abbosFayziboev@gmail.com
 */

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Response {
    private boolean isError;
    private Object data;
    private String message;
}
