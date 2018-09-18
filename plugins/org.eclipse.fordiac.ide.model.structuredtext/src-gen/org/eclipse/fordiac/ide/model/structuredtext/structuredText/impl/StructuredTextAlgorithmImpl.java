/**
 * generated by Xtext 2.11.0
 */
package org.eclipse.fordiac.ide.model.structuredtext.structuredText.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.fordiac.ide.model.libraryElement.VarDeclaration;

import org.eclipse.fordiac.ide.model.structuredtext.structuredText.StatementList;
import org.eclipse.fordiac.ide.model.structuredtext.structuredText.StructuredTextAlgorithm;
import org.eclipse.fordiac.ide.model.structuredtext.structuredText.StructuredTextPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Algorithm</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.fordiac.ide.model.structuredtext.structuredText.impl.StructuredTextAlgorithmImpl#getLocalVariables <em>Local Variables</em>}</li>
 *   <li>{@link org.eclipse.fordiac.ide.model.structuredtext.structuredText.impl.StructuredTextAlgorithmImpl#getStatements <em>Statements</em>}</li>
 * </ul>
 *
 * @generated
 */
public class StructuredTextAlgorithmImpl extends MinimalEObjectImpl.Container implements StructuredTextAlgorithm
{
  /**
   * The cached value of the '{@link #getLocalVariables() <em>Local Variables</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getLocalVariables()
   * @generated
   * @ordered
   */
  protected EList<VarDeclaration> localVariables;

  /**
   * The cached value of the '{@link #getStatements() <em>Statements</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getStatements()
   * @generated
   * @ordered
   */
  protected StatementList statements;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected StructuredTextAlgorithmImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass()
  {
    return StructuredTextPackage.Literals.STRUCTURED_TEXT_ALGORITHM;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
public EList<VarDeclaration> getLocalVariables()
  {
    if (localVariables == null)
    {
      localVariables = new EObjectContainmentEList<VarDeclaration>(VarDeclaration.class, this, StructuredTextPackage.STRUCTURED_TEXT_ALGORITHM__LOCAL_VARIABLES);
    }
    return localVariables;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
public StatementList getStatements()
  {
    return statements;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetStatements(StatementList newStatements, NotificationChain msgs)
  {
    StatementList oldStatements = statements;
    statements = newStatements;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, StructuredTextPackage.STRUCTURED_TEXT_ALGORITHM__STATEMENTS, oldStatements, newStatements);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
public void setStatements(StatementList newStatements)
  {
    if (newStatements != statements)
    {
      NotificationChain msgs = null;
      if (statements != null)
        msgs = ((InternalEObject)statements).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - StructuredTextPackage.STRUCTURED_TEXT_ALGORITHM__STATEMENTS, null, msgs);
      if (newStatements != null)
        msgs = ((InternalEObject)newStatements).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - StructuredTextPackage.STRUCTURED_TEXT_ALGORITHM__STATEMENTS, null, msgs);
      msgs = basicSetStatements(newStatements, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, StructuredTextPackage.STRUCTURED_TEXT_ALGORITHM__STATEMENTS, newStatements, newStatements));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
  {
    switch (featureID)
    {
      case StructuredTextPackage.STRUCTURED_TEXT_ALGORITHM__LOCAL_VARIABLES:
        return ((InternalEList<?>)getLocalVariables()).basicRemove(otherEnd, msgs);
      case StructuredTextPackage.STRUCTURED_TEXT_ALGORITHM__STATEMENTS:
        return basicSetStatements(null, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType)
  {
    switch (featureID)
    {
      case StructuredTextPackage.STRUCTURED_TEXT_ALGORITHM__LOCAL_VARIABLES:
        return getLocalVariables();
      case StructuredTextPackage.STRUCTURED_TEXT_ALGORITHM__STATEMENTS:
        return getStatements();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @SuppressWarnings("unchecked")
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case StructuredTextPackage.STRUCTURED_TEXT_ALGORITHM__LOCAL_VARIABLES:
        getLocalVariables().clear();
        getLocalVariables().addAll((Collection<? extends VarDeclaration>)newValue);
        return;
      case StructuredTextPackage.STRUCTURED_TEXT_ALGORITHM__STATEMENTS:
        setStatements((StatementList)newValue);
        return;
    }
    super.eSet(featureID, newValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eUnset(int featureID)
  {
    switch (featureID)
    {
      case StructuredTextPackage.STRUCTURED_TEXT_ALGORITHM__LOCAL_VARIABLES:
        getLocalVariables().clear();
        return;
      case StructuredTextPackage.STRUCTURED_TEXT_ALGORITHM__STATEMENTS:
        setStatements((StatementList)null);
        return;
    }
    super.eUnset(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean eIsSet(int featureID)
  {
    switch (featureID)
    {
      case StructuredTextPackage.STRUCTURED_TEXT_ALGORITHM__LOCAL_VARIABLES:
        return localVariables != null && !localVariables.isEmpty();
      case StructuredTextPackage.STRUCTURED_TEXT_ALGORITHM__STATEMENTS:
        return statements != null;
    }
    return super.eIsSet(featureID);
  }

} //StructuredTextAlgorithmImpl
