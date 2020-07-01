package com.codecool.junit5;

import org.junit.jupiter.api.*;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static org.junit.jupiter.api.Assertions.*;

class PartReaderTest {

    PartReader reader;

    @BeforeEach
    void init(){
        reader = new PartReader();
        reader.setup("/Users/durlesteanu/Desktop/cap.txt", 1, 1000);

    }

    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.RUNTIME)
    @Tag("Main")
    @Test
    public @interface MainTest{}

    @Nested
    class SetupTest {

        @MainTest
        @DisplayName("Testing setup with 'start row' > 'end row'")
        void testIsIllegalRowSetup() {
            assertThrows(IllegalArgumentException.class, () -> {
                        reader.setup("file.txt", 2, 1);
                    },
                    "Should throw an error message when start line > end line");
        }

        @MainTest
        @DisplayName("Testing setup with negative start row")
        void testIsIllegalNegativeValueRowSetup() {
            assertThrows(IllegalArgumentException.class, () -> {
                        reader.setup("file.txt", 1, 2);
                    },
                    "Should throw an error message when start line is -1");}

        @MainTest
        @DisplayName("Testing setup with value of 0 as start row")
        void testIsIllegalZeroRowSetup() {
            assertThrows(IllegalArgumentException.class, () -> {
                        reader.setup("file.txt", 0, 2);
                    },
                    "Should throw an error message when start line is 0");

        }
    }

    @Nested
    class ReadIsWorking {

        @MainTest
        @DisplayName("Checking if result is not a null")
        void testIsReadNotNull() {
            assertNotNull(reader.read());

        }
    }

    @Nested
    class ReadLinesWorking {

        @MainTest
        @DisplayName("Checking if result is not null")
        void testIsReadLinesNotNull() {
            assertNotNull(reader.readLines());
        }

        @MainTest
        @DisplayName("Check if returned value is equal to given")
        void testIsReadLinesReturnValue(){
            reader.setup("/Users/durlesteanu/Desktop/cap.txt", 1, 1);
            String text = "  It started out as just another Saturday.  April 26, 1986.  John R.";
            assertEquals(reader.readLines(), text);

        }
    }
}