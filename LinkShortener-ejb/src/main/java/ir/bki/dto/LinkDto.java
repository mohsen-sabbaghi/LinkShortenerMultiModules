package ir.bki.dto;
import lombok.Data;

import javax.ejb.Stateless;
import java.io.Serializable;

@Data
@Stateless
public class LinkDto implements Serializable {

    private String longLink;
    private String expiresDate;
    private String desirelink;

}
