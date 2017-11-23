package maxb.facedating.aws;

import org.springframework.web.multipart.MultipartFile;

/**
 * Created by MaxB on 09/11/2017.
 */
public interface AwsS3Service {

    String s3Upload(String keyName, String uploadPath);

    String s3UploadMultipartFile(String keyName, MultipartFile file);
}
