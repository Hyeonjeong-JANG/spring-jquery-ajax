package shop.mtcoding.blog.board;

import lombok.Data;

@Data
public class ApiUtil<T> {
    private Integer status;
    private String msg;
    private T body;

    public ApiUtil(T body) { // 이렇게도 가져다 쓸 수 있고
        this.status = 200;
        this.msg = "성공";
        this.body = body;
    }

    public ApiUtil(Integer status, String msg) { // 따로 이렇게도 쓸 수 있어.
        this.status = status;
        this.msg = msg;
        this.body = null;
    }
}
