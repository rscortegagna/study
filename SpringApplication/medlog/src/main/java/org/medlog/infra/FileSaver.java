package org.medlog.infra;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;

@Component
public class FileSaver {

    @Autowired
    private HttpServletRequest httpServletRequest;

    public String write(String baseFolder, MultipartFile file) {
        try {

            String realPath = httpServletRequest.getServletContext().getRealPath("/" + baseFolder);
            String path = realPath + "/" + file.getOriginalFilename();
            file.transferTo(new File(path));

            return baseFolder + "/" + file.getOriginalFilename();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

}
