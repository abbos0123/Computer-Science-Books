package uz.uniquecode.serviceb.model;

import lombok.Builder;
import lombok.Data;

/**
 * Author: Abbos Fayziboev
 * Date: 14/04/23
 * Email: abbosFayziboev@gmail.com
 */

@Data
@Builder
public class Response {
    private boolean isError;
    private Object data;
    private String message;
}
