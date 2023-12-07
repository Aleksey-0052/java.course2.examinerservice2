package pro.sky.java.course2.examinerservice2.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.java.course2.examinerservice2.domain.Question;
import pro.sky.java.course2.examinerservice2.exceptions.QuestionAlreadyAddedException;
import pro.sky.java.course2.examinerservice2.exceptions.QuestionNotFoundException;
import pro.sky.java.course2.examinerservice2.repository.QuestionRepository;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static pro.sky.java.course2.examinerservice2.constants.QuestionsConstants.*;

@ExtendWith(MockitoExtension.class)
class JavaQuestionServiceTest {

    @Mock
    private QuestionRepository repositoryMock;
    @InjectMocks
    private JavaQuestionService out;


    @Test
    void testAddQuestionAnswer_Success() {

        when(repositoryMock.add(javaQuest1))
                .thenReturn(javaQuest1);

        assertEquals(javaQuest1, out.add(javaQuestion1, javaAnswer1));
        verify(repositoryMock, times(1)).add(javaQuest1);

    }

    @Test
    void testAddQuestionAnswer_QuestionAlreadyAdded_ThrowsQuestionAlreadyAddedException() {

        String javaQuestion11 = "Вопрос 11";
        String javaAnswer11 = "Ответ 11";
        // отсутствующий объект

        when(repositoryMock.add(any()))
                .thenThrow(QuestionAlreadyAddedException.class);

        assertThrows(QuestionAlreadyAddedException.class, () -> out.add(javaQuestion11, javaAnswer11));
        // Срабатывает при добавлении отсутствующего элемента

    }

    @Test
    void testAddQuestion_Success() {

        when(repositoryMock.add(javaQuest1))
                .thenReturn(javaQuest1);

        assertEquals(javaQuest1, out.add(javaQuest1));
        verify(repositoryMock, times(1)).add(javaQuest1);     

    }

    @Test
    void testAddQuestion_QuestionAlreadyAdded_ThrowsQuestionAlreadyAddedException() {

        Question javaQuest11 = new Question("Вопрос 11", "Ответ 11");
        // отсутствующий объект

        when(repositoryMock.add(any()))
                .thenThrow(QuestionAlreadyAddedException.class);

        assertThrows(QuestionAlreadyAddedException.class, () -> out.add(javaQuest11));
        // При добавлении отсутствующих объектов тоже срабатывает

    }

    @Test
    void testRemoveQuestion_Success() {

        when(repositoryMock.remove(javaQuest5))
                .thenReturn(javaQuest5);

        assertEquals(javaQuest5, out.remove(javaQuest5));
        verify(repositoryMock, times(1)).remove(javaQuest5);

    }

    @Test
    void  testRemoveQuestion_QuestionNotFound_ThrowsQuestionNotFoundException() {

        Question javaQuest11 = new Question("Вопрос 11", "Ответ 11");
        // отсутствующий объект

        when(repositoryMock.remove(any()))
                .thenThrow(QuestionNotFoundException.class);

        assertThrows(QuestionNotFoundException.class, () -> out.remove(javaQuest1));
        // Срабатывает при удалении имеющегося элемента

    }

    @Test
    void testGetAll_Success() {


        when(repositoryMock.getAll())
                .thenReturn(ALL_JAVA_QUESTIONS);

        assertIterableEquals(ALL_JAVA_QUESTIONS, out.getAll());             // Сравнивает две коллекции
//        assertEquals(ALL_JAVA_QUESTIONS, out.getAll());                   // Сравнивает два объекта
                                                                            // можно использовать первый или второй

        assertEquals(ALL_JAVA_QUESTIONS.size(), out.getAll().size());
//        assertNotNull(out.getAll());
//        assertTrue(out.getAll().containsAll(ALL_JAVA_QUESTIONS));
        verify(repositoryMock, times(2)).getAll();  // Вызывается 2 раза

    }

}