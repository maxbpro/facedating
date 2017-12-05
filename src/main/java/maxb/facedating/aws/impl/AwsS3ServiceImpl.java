package maxb.facedating.aws.impl;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.transfer.TransferManager;
import com.amazonaws.services.s3.transfer.Upload;
import maxb.facedating.aws.AwsS3Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

/**
 * Created by MaxB on 09/11/2017.
 */
@Service
public class AwsS3ServiceImpl implements AwsS3Service {

    @Autowired
    private AmazonS3 s3client;

    //@Value("${aws_namecard_bucket}")
    private String bucketName = "maxb.faces";

    @Override
    public String s3Upload(String keyName, String uploadPath) {

        try {

            File file = new File(uploadPath);
            s3client.putObject(new PutObjectRequest(bucketName, keyName, file)
                    .withCannedAcl(CannedAccessControlList.PublicRead));

        } catch (Exception ex){
            ex.printStackTrace();
        }

        return "https://s3-ap-southeast-1.amazonaws.com/" + bucketName + "/" + keyName;
    }

    @Override
    public String s3UploadMultipartFile(String keyName, MultipartFile file) {

        try {

            TransferManager transferManager = new TransferManager(s3client);
            // Otherwise: (Service: Amazon S3; Status Code: 301; Error Code:
            // PermanentRedirect)
             //s3client.setRegion(Region.getRegion(Regions.));
            ObjectMetadata objectMetadata = new ObjectMetadata();
            //objectMetadata.setContentType("image/png");
            objectMetadata.setContentDisposition("attachment; filename=" + file.getOriginalFilename());

            Upload upload = transferManager.upload(
                    new PutObjectRequest(bucketName, keyName, file.getInputStream(), objectMetadata)
                            .withCannedAcl(CannedAccessControlList.PublicRead));

            upload.waitForUploadResult();

            return "https://s3-ap-southeast-1.amazonaws.com/" + bucketName + "/" + keyName;

        } catch (Exception ex){
            ex.printStackTrace();
            return null;
        }

    }
}
