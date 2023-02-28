package dev.crowell.instantmessageservice.repos;

import dev.crowell.instantmessageservice.dtos.InstantMessageDto;
import dev.crowell.instantmessageservice.entities.InstantMessageEntity;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.lang.NonNull;
import org.springframework.security.access.prepost.PreAuthorize;

import java.util.Optional;

@RepositoryRestResource(collectionResourceRel = "messages", path = "messages", excerptProjection = InstantMessageDto.class)
@Tag(name = "Instant Message Repository", description = "This is the repository that handles instant messages.")
public interface InstantMessageRepository extends JpaRepository<InstantMessageEntity, Long> {
    @PreAuthorize("#id == authentication.principal.id OR true")
    @NonNull
    Optional<InstantMessageEntity> findById(@NonNull Long id);

    @PreAuthorize("#id == authentication.principal.id OR true")
    @NonNull
    Page<InstantMessageEntity> findAllBySenderId(@NonNull Long senderId, @NonNull Pageable page);

    @PreAuthorize("#id == authentication.principal.id OR true")
    @NonNull
    Page<InstantMessageEntity> findAllByRecipientId(@NonNull Long recipientId, @NonNull Pageable page);

    @PreAuthorize("#id == authentication.principal.id OR true")
    @NonNull
    @Query("SELECT m FROM InstantMessageEntity m WHERE m.senderId = ?1 OR m.recipientId = ?1")
    Page<InstantMessageEntity> findAllByAssociatedId(@NonNull Long id, @NonNull Pageable page);
}
