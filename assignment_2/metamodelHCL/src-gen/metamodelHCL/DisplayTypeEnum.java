/**
 */
package metamodelHCL;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Display Type Enum</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see metamodelHCL.MetamodelHCLPackage#getDisplayTypeEnum()
 * @model
 * @generated
 */
public enum DisplayTypeEnum implements Enumerator {
	/**
	 * The '<em><b>Four K</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #FOUR_K_VALUE
	 * @generated
	 * @ordered
	 */
	FOUR_K(0, "FourK", "FourK"),

	/**
	 * The '<em><b>Five K</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #FIVE_K_VALUE
	 * @generated
	 * @ordered
	 */
	FIVE_K(1, "FiveK", "FiveK"),

	/**
	 * The '<em><b>HD</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #HD_VALUE
	 * @generated
	 * @ordered
	 */
	HD(2, "HD", "HD"),

	/**
	 * The '<em><b>Full HD</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #FULL_HD_VALUE
	 * @generated
	 * @ordered
	 */
	FULL_HD(3, "FullHD", "FullHD");

	/**
	 * The '<em><b>Four K</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #FOUR_K
	 * @model name="FourK"
	 * @generated
	 * @ordered
	 */
	public static final int FOUR_K_VALUE = 0;

	/**
	 * The '<em><b>Five K</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #FIVE_K
	 * @model name="FiveK"
	 * @generated
	 * @ordered
	 */
	public static final int FIVE_K_VALUE = 1;

	/**
	 * The '<em><b>HD</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #HD
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int HD_VALUE = 2;

	/**
	 * The '<em><b>Full HD</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #FULL_HD
	 * @model name="FullHD"
	 * @generated
	 * @ordered
	 */
	public static final int FULL_HD_VALUE = 3;

	/**
	 * An array of all the '<em><b>Display Type Enum</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final DisplayTypeEnum[] VALUES_ARRAY = new DisplayTypeEnum[] { FOUR_K, FIVE_K, HD, FULL_HD, };

	/**
	 * A public read-only list of all the '<em><b>Display Type Enum</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<DisplayTypeEnum> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Display Type Enum</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param literal the literal.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static DisplayTypeEnum get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			DisplayTypeEnum result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Display Type Enum</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param name the name.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static DisplayTypeEnum getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			DisplayTypeEnum result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Display Type Enum</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the integer value.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static DisplayTypeEnum get(int value) {
		switch (value) {
		case FOUR_K_VALUE:
			return FOUR_K;
		case FIVE_K_VALUE:
			return FIVE_K;
		case HD_VALUE:
			return HD;
		case FULL_HD_VALUE:
			return FULL_HD;
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final int value;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String name;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String literal;

	/**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private DisplayTypeEnum(int value, String name, String literal) {
		this.value = value;
		this.name = name;
		this.literal = literal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getValue() {
		return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLiteral() {
		return literal;
	}

	/**
	 * Returns the literal value of the enumerator, which is its string representation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		return literal;
	}

} //DisplayTypeEnum
