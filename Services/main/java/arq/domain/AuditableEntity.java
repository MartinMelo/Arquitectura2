package arq.domain;

import java.util.Date;

import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@MappedSuperclass
public abstract class AuditableEntity extends AbstractEntity {

	@Temporal(TemporalType.TIMESTAMP)
	private Date creationTimestamp;

	@Temporal(TemporalType.TIMESTAMP)
	private Date modificationTimestamp;

}
