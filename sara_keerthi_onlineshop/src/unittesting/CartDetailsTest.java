package unittesting;

import models.Article;
import models.CartDetails;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

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

        Assertions.assertEquals(article, actualArticle);
        assertEquals(amount, actualAmount);
    }
}