package com.file.fileReader;

import com.file.fileReader.service.InputFileService;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.verify;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class FileReaderApplicationTest {

    @Mock private FileReaderApplication fileReaderApplication;

    @Mock private InputFileService inputFileService;

    @Test
    public void main() throws IOException {
        fileReaderApplication.main(new String[] {});
    }

    @Test
    public void test() throws IOException {
        inputFileService.processFiles();
        verify(inputFileService, atLeast(1)).processFiles();
    }

}