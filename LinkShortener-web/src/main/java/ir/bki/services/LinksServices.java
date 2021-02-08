package ir.bki.services;

import ir.bki.dao.LinksDao;
import ir.bki.dto.LinkDto;
import ir.bki.entities.Links;
import ir.bki.util.BaseConversion;
import lombok.Data;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.ISODateTimeFormat;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.NoResultException;


@Stateless
@Data
//@Singleton
public class LinksServices {

    @Inject
    private LinksDao linksDao;
    @Inject
    private BaseConversion baseConversion;

    public Links createLink(LinkDto linkDto) {
        Links links = new Links();
        DateTimeFormatter parser = ISODateTimeFormat.dateTimeParser();
        DateTime dateTime = parser.parseDateTime(linkDto.getExpiresDate());
        links.setRedirectLink(linkDto.getLongLink());
        links.setExpiresDate(dateTime.toDate());
        links.setHttpStatusCode(303);
        links.setEnabled(true);
        links.setCreatedDate(dateTime.toDate());
        Links response = linksDao.create(links);
        links.setShortLink(baseConversion.encode(response.getId()));
        return linksDao.getEm().merge(links);

    }

    public Links retrieveOne(long id) {
        Links res;
        try {
            res = linksDao.getEm().createNamedQuery(Links.FIND_BY_ID, Links.class).setParameter("id", id).getSingleResult();

        } catch (NoResultException e) {

                return null;
//            throw new NotFoundException();
        }
        return res;
    }
}
