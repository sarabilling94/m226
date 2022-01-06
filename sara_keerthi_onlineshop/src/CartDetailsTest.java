import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class CartDetailsTest {

    @Mock
    Article article;

    int amount = 3;

    CartDetails details;
    @BeforeEach
    void setup(){
        details = new CartDetails(article, amount);
    }

    @org.junit.jupiter.api.Test
    void getArticleTest() {
        Article actualArticle = details.getArticle();
        int actualAmount = details.getAmount();

    }
}