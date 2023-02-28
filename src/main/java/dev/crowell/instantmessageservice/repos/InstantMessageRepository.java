package dev.crowell.instantmessageservice.repos;

import dev.crowell.instantmessageservice.dtos.InstantMessageDto;
import dev.crowell.instantmessageservice.entities.InstantMessageEntity;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.lang.NonNull;

import java.util.Optional;

@RepositoryRestResource(collectionResourceRel = "messages", path = "messages", excerptProjection = InstantMessageDto.class)
@Tag(name = "Instant Message Repository", description = "This is the repository that handles instant messages.")
public interface InstantMessageRepository extends JpaRepository<InstantMessageEntity, Long> {

    @NonNull
    Optional<InstantMessageEntity> findById(@NonNull Long id);
    @NonNull
    Page<InstantMessageEntity> findAllBySenderId(@NonNull Long senderId, @NonNull Pageable page);
    @NonNull
    Page<InstantMessageEntity> findAllByRecipientId(@NonNull Long recipientId, @NonNull Pageable page);
}
