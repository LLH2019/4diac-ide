/**
 * Copyright (c) 2020 Johannes Kepler University Linz
 * 
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Contributors:
 *   Ernst Blecha - initial API and implementation and/or initial documentation
 */
package org.eclipse.fordiac.ide.export.forte_ng.tests;

import org.eclipse.fordiac.ide.export.forte_ng.tests.ForteNgTestBase;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.junit.Assert;

@SuppressWarnings("all")
public abstract class ForteNgArrayAtAccessXtend extends ForteNgTestBase {
  private static final String ALGORITHM_NAME = "algorithm";
  
  protected static final boolean VALID_ACCESS = true;
  
  protected static final boolean INVALID_ACCESS = (!ForteNgArrayAtAccessXtend.VALID_ACCESS);
  
  protected void testLocatedArrayAtAccess(final String sourceType, final String accessType, final int arrayStart, final int arrayStop, final String accessor, final int index, final String value, final boolean isValid) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("VAR");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("variable : ");
    _builder.append(sourceType, "  ");
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    _builder.append("  ");
    _builder.append("partial AT variable : ARRAY [");
    _builder.append(arrayStart, "  ");
    _builder.append("..");
    _builder.append(arrayStop, "  ");
    _builder.append("] OF ");
    _builder.append(accessType, "  ");
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    _builder.append("END_VAR");
    _builder.newLine();
    _builder.newLine();
    _builder.append("partial.");
    _builder.append(accessor);
    _builder.append(index);
    _builder.append(" := ");
    _builder.append(value);
    _builder.append(";");
    this.functionBlock.getAlgorithm().add(this.createSTAlgorithm(ForteNgArrayAtAccessXtend.ALGORITHM_NAME, _builder.toString()));
    CharSequence generatedCode = this.stAlgorithmFilter.generate(this.castAlgorithm(this.functionBlock.getAlgorithmNamed(ForteNgArrayAtAccessXtend.ALGORITHM_NAME)), this.errors);
    if ((isValid == ForteNgArrayAtAccessXtend.VALID_ACCESS)) {
      ForteNgTestBase.assertNoErrors(this.errors);
      Assert.assertNotNull(generatedCode);
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("CIEC_");
      _builder_1.append(sourceType);
      _builder_1.append(" variable;");
      _builder_1.newLineIfNotEmpty();
      _builder_1.append("ARRAY_AT<CIEC_");
      _builder_1.append(accessType);
      _builder_1.append(", CIEC_");
      _builder_1.append(sourceType);
      _builder_1.append(", ");
      _builder_1.append(arrayStart);
      _builder_1.append(", ");
      _builder_1.append(arrayStop);
      _builder_1.append("> partial(variable);");
      _builder_1.newLineIfNotEmpty();
      _builder_1.append("partial.partial<CIEC_");
      _builder_1.append(accessType);
      _builder_1.append(",");
      _builder_1.append(index);
      _builder_1.append(">() = ");
      _builder_1.append(value);
      _builder_1.append(";");
      _builder_1.newLineIfNotEmpty();
      Assert.assertEquals(_builder_1.toString(), generatedCode.toString());
    } else {
      ForteNgTestBase.assertErrors(this.errors);
      Assert.assertNull(generatedCode);
      ForteNgTestBase.assertErrorMessages(this.errors, "Incorrect partial access: index not within limits.");
    }
  }
}