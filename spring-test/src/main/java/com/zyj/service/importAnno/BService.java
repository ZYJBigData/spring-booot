package com.zyj.service.importAnno;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.lang.Nullable;

import java.util.function.Predicate;

public class BService implements ImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        return new String[0];
    }

    @Override
    @Nullable
    public Predicate<String> getExclusionFilter() {
        return null;
    }
}
