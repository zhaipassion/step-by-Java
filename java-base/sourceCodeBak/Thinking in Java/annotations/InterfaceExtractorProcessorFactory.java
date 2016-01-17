//package com.books.book03.annotations;
////: annotations/InterfaceExtractorProcessorFactory.java
//// APT-based annotation processing.
//import java.util.*;
//
//public class InterfaceExtractorProcessorFactory
//  implements AnnotationProcessorFactory {
//  public AnnotationProcessor getProcessorFor(
//    Set<AnnotationTypeDeclaration> atds,
//    AnnotationProcessorEnvironment env) {
//    return new InterfaceExtractorProcessor(env);
//  }
//  public Collection<String> supportedAnnotationTypes() {
//    return
//     Collections.singleton("annotations.ExtractInterface");
//  }
//  public Collection<String> supportedOptions() {
//    return Collections.emptySet();
//  }
//} ///:~
