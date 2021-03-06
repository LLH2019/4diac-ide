/**
 * generated by Xtext 2.11.0
 */
package org.eclipse.fordiac.ide.model.structuredtext.ide;

import com.google.inject.Guice;
import com.google.inject.Injector;
import org.eclipse.fordiac.ide.model.structuredtext.StructuredTextRuntimeModule;
import org.eclipse.fordiac.ide.model.structuredtext.StructuredTextStandaloneSetup;
import org.eclipse.xtext.util.Modules2;

/**
 * Initialization support for running Xtext languages as language servers.
 */
@SuppressWarnings("all")
public class StructuredTextIdeSetup extends StructuredTextStandaloneSetup {
  @Override
  public Injector createInjector() {
    StructuredTextRuntimeModule _structuredTextRuntimeModule = new StructuredTextRuntimeModule();
    StructuredTextIdeModule _structuredTextIdeModule = new StructuredTextIdeModule();
    return Guice.createInjector(Modules2.mixin(_structuredTextRuntimeModule, _structuredTextIdeModule));
  }
}
