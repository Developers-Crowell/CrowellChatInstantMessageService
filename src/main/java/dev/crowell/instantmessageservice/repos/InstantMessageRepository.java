package dev.crowell.instantmessageservice.repos;

import dev.crowell.instantmessageservice.entities.InstantMessageEntity;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveSortingRepository;
import org.springframework.lang.NonNull;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

import java.util.Optional;

@Repository
public interface InstantMessageRepository extends ReactiveSortingRepository<InstantMessageEntity, Long> {
    @PreAuthorize("#id == authentication.principal.id OR true")
    @NonNull
    Optional<InstantMessageEntity> findById(@NonNull Long id);

    @PreAuthorize("#id == authentication.principal.id OR true")
    @NonNull
    Flux<InstantMessageEntity> findAllBySenderId(@NonNull Long senderId);

    @PreAuthorize("#id == authentication.principal.id OR true")
    @NonNull
    Flux<InstantMessageEntity> findAllByRecipientId(@NonNull Long recipientId);

    @PreAuthorize("#id == authentication.principal.id OR true")
    @NonNull
    @Query("SELECT m FROM InstantMessageEntity m WHERE m.senderId = ?1 OR m.recipientId = ?1")
    Flux<InstantMessageEntity> findAllByAssociatedId(@NonNull Long id);
}
