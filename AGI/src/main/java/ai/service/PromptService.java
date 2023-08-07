package ai.service;

import ai.model.Prompt;
import ai.repository.PromptsRepository;
import io.quarkus.hibernate.orm.panache.Panache;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.util.UUID;

@ApplicationScoped
public class PromptService {


    @Inject
    PromptsRepository promptsRepository;

    @Transactional
    public UUID addPrompt(Prompt prompt) {

        Prompt persistedPrompt = Prompt.<Prompt>findById(Panache.getEntityManager().merge(prompt).getId());
        return persistedPrompt.getId();
    }


    public Prompt findPromptById(UUID id) {

        return promptsRepository.findById(id);
    }
}
