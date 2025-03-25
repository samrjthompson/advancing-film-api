package uk.co.advancingfilm.model;

import java.util.Objects;
import uk.co.advancingfilm.service.ByteSizeLimit;

public class ContentRequest {

    @ByteSizeLimit
    private String textContent;

    private String getTextContent() {
        return textContent;
    }

    private ContentRequest textContent(String textContent) {
        this.textContent = textContent;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ContentRequest that = (ContentRequest) o;
        return Objects.equals(textContent, that.textContent);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(textContent);
    }
}
