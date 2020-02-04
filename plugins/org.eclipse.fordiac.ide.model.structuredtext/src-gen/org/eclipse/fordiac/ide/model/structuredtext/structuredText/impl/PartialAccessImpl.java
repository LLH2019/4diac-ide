/**
 * generated by Xtext 2.20.0
 */
package org.eclipse.fordiac.ide.model.structuredtext.structuredText.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.fordiac.ide.model.structuredtext.structuredText.PartialAccess;
import org.eclipse.fordiac.ide.model.structuredtext.structuredText.StructuredTextPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Partial Access</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.fordiac.ide.model.structuredtext.structuredText.impl.PartialAccessImpl#isDwordaccess <em>Dwordaccess</em>}</li>
 *   <li>{@link org.eclipse.fordiac.ide.model.structuredtext.structuredText.impl.PartialAccessImpl#getIndex <em>Index</em>}</li>
 *   <li>{@link org.eclipse.fordiac.ide.model.structuredtext.structuredText.impl.PartialAccessImpl#isWordaccess <em>Wordaccess</em>}</li>
 *   <li>{@link org.eclipse.fordiac.ide.model.structuredtext.structuredText.impl.PartialAccessImpl#isByteaccess <em>Byteaccess</em>}</li>
 *   <li>{@link org.eclipse.fordiac.ide.model.structuredtext.structuredText.impl.PartialAccessImpl#isBitaccess <em>Bitaccess</em>}</li>
 * </ul>
 *
 * @generated
 */
public class PartialAccessImpl extends MinimalEObjectImpl.Container implements PartialAccess
{
  /**
   * The default value of the '{@link #isDwordaccess() <em>Dwordaccess</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isDwordaccess()
   * @generated
   * @ordered
   */
  protected static final boolean DWORDACCESS_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isDwordaccess() <em>Dwordaccess</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isDwordaccess()
   * @generated
   * @ordered
   */
  protected boolean dwordaccess = DWORDACCESS_EDEFAULT;

  /**
   * The default value of the '{@link #getIndex() <em>Index</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getIndex()
   * @generated
   * @ordered
   */
  protected static final int INDEX_EDEFAULT = 0;

  /**
   * The cached value of the '{@link #getIndex() <em>Index</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getIndex()
   * @generated
   * @ordered
   */
  protected int index = INDEX_EDEFAULT;

  /**
   * The default value of the '{@link #isWordaccess() <em>Wordaccess</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isWordaccess()
   * @generated
   * @ordered
   */
  protected static final boolean WORDACCESS_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isWordaccess() <em>Wordaccess</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isWordaccess()
   * @generated
   * @ordered
   */
  protected boolean wordaccess = WORDACCESS_EDEFAULT;

  /**
   * The default value of the '{@link #isByteaccess() <em>Byteaccess</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isByteaccess()
   * @generated
   * @ordered
   */
  protected static final boolean BYTEACCESS_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isByteaccess() <em>Byteaccess</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isByteaccess()
   * @generated
   * @ordered
   */
  protected boolean byteaccess = BYTEACCESS_EDEFAULT;

  /**
   * The default value of the '{@link #isBitaccess() <em>Bitaccess</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isBitaccess()
   * @generated
   * @ordered
   */
  protected static final boolean BITACCESS_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isBitaccess() <em>Bitaccess</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isBitaccess()
   * @generated
   * @ordered
   */
  protected boolean bitaccess = BITACCESS_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected PartialAccessImpl()
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
    return StructuredTextPackage.Literals.PARTIAL_ACCESS;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean isDwordaccess()
  {
    return dwordaccess;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setDwordaccess(boolean newDwordaccess)
  {
    boolean oldDwordaccess = dwordaccess;
    dwordaccess = newDwordaccess;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, StructuredTextPackage.PARTIAL_ACCESS__DWORDACCESS, oldDwordaccess, dwordaccess));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public int getIndex()
  {
    return index;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setIndex(int newIndex)
  {
    int oldIndex = index;
    index = newIndex;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, StructuredTextPackage.PARTIAL_ACCESS__INDEX, oldIndex, index));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean isWordaccess()
  {
    return wordaccess;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setWordaccess(boolean newWordaccess)
  {
    boolean oldWordaccess = wordaccess;
    wordaccess = newWordaccess;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, StructuredTextPackage.PARTIAL_ACCESS__WORDACCESS, oldWordaccess, wordaccess));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean isByteaccess()
  {
    return byteaccess;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setByteaccess(boolean newByteaccess)
  {
    boolean oldByteaccess = byteaccess;
    byteaccess = newByteaccess;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, StructuredTextPackage.PARTIAL_ACCESS__BYTEACCESS, oldByteaccess, byteaccess));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean isBitaccess()
  {
    return bitaccess;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setBitaccess(boolean newBitaccess)
  {
    boolean oldBitaccess = bitaccess;
    bitaccess = newBitaccess;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, StructuredTextPackage.PARTIAL_ACCESS__BITACCESS, oldBitaccess, bitaccess));
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
      case StructuredTextPackage.PARTIAL_ACCESS__DWORDACCESS:
        return isDwordaccess();
      case StructuredTextPackage.PARTIAL_ACCESS__INDEX:
        return getIndex();
      case StructuredTextPackage.PARTIAL_ACCESS__WORDACCESS:
        return isWordaccess();
      case StructuredTextPackage.PARTIAL_ACCESS__BYTEACCESS:
        return isByteaccess();
      case StructuredTextPackage.PARTIAL_ACCESS__BITACCESS:
        return isBitaccess();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case StructuredTextPackage.PARTIAL_ACCESS__DWORDACCESS:
        setDwordaccess((Boolean)newValue);
        return;
      case StructuredTextPackage.PARTIAL_ACCESS__INDEX:
        setIndex((Integer)newValue);
        return;
      case StructuredTextPackage.PARTIAL_ACCESS__WORDACCESS:
        setWordaccess((Boolean)newValue);
        return;
      case StructuredTextPackage.PARTIAL_ACCESS__BYTEACCESS:
        setByteaccess((Boolean)newValue);
        return;
      case StructuredTextPackage.PARTIAL_ACCESS__BITACCESS:
        setBitaccess((Boolean)newValue);
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
      case StructuredTextPackage.PARTIAL_ACCESS__DWORDACCESS:
        setDwordaccess(DWORDACCESS_EDEFAULT);
        return;
      case StructuredTextPackage.PARTIAL_ACCESS__INDEX:
        setIndex(INDEX_EDEFAULT);
        return;
      case StructuredTextPackage.PARTIAL_ACCESS__WORDACCESS:
        setWordaccess(WORDACCESS_EDEFAULT);
        return;
      case StructuredTextPackage.PARTIAL_ACCESS__BYTEACCESS:
        setByteaccess(BYTEACCESS_EDEFAULT);
        return;
      case StructuredTextPackage.PARTIAL_ACCESS__BITACCESS:
        setBitaccess(BITACCESS_EDEFAULT);
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
      case StructuredTextPackage.PARTIAL_ACCESS__DWORDACCESS:
        return dwordaccess != DWORDACCESS_EDEFAULT;
      case StructuredTextPackage.PARTIAL_ACCESS__INDEX:
        return index != INDEX_EDEFAULT;
      case StructuredTextPackage.PARTIAL_ACCESS__WORDACCESS:
        return wordaccess != WORDACCESS_EDEFAULT;
      case StructuredTextPackage.PARTIAL_ACCESS__BYTEACCESS:
        return byteaccess != BYTEACCESS_EDEFAULT;
      case StructuredTextPackage.PARTIAL_ACCESS__BITACCESS:
        return bitaccess != BITACCESS_EDEFAULT;
    }
    return super.eIsSet(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String toString()
  {
    if (eIsProxy()) return super.toString();

    StringBuilder result = new StringBuilder(super.toString());
    result.append(" (dwordaccess: ");
    result.append(dwordaccess);
    result.append(", index: ");
    result.append(index);
    result.append(", wordaccess: ");
    result.append(wordaccess);
    result.append(", byteaccess: ");
    result.append(byteaccess);
    result.append(", bitaccess: ");
    result.append(bitaccess);
    result.append(')');
    return result.toString();
  }

} //PartialAccessImpl