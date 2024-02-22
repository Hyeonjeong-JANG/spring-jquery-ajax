package shop.mtcoding.blog.board;

import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class BoardApiController { // api를 돌려주는 컨트롤러(ajax 통신을 위한 컨트롤러)
    private final BoardRepository boardRepository;

    // http://localhost:8080/api/boards 하면 제이슨으로 보임
    @GetMapping("/api/boards") // api를 하면 보통 복수형을 쓴다. /api/boards/1 이러면 보드들 중 하나를 줘.
    public ApiUtil<?> findAll(HttpServletResponse response) { // 물음표 자리에 List<Board>넣어도 됨. 근데 그냥 에이피아이유틸<?>로 해라. 무조근!!! 리턴하는 것이 오브젝트이기 때문에 스프링이 자동으로 제이슨이 리턴되게 해준다.
//        response.setStatus(400); // 이렇게 강제로 상태코드를 바꿔주면 index.mustache의 done이 아니라 fail이 실행됨.
        List<Board> boardList = boardRepository.selectAll(); // 이렇게 하면 그냥 데이터를 주는 거잖아. 그런데 꼭 두 가지를 같이 줘야해. 상태코드랑 메시지. 그래야 좋아.
//        return new ApiUtil<>(400, "유저네임이 중복되었습니다.");
//        return new ApiUtil<>(401, "인증이 되지 않았습니다.");
        return new ApiUtil<>(boardList);// MessageConverter가 발동됨. 제이슨으로 바뀌어서 날아간다 이 말이다.
    }


}
