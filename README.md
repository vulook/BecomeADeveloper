# BecomeADeveloper: Алгоритм пошуку першого унікального символу

### Завдання: Розробити алгоритм програми, яка знаходить перший унікальний символ у тексті.

### Опис алгоритму:

**Вхід**: Довільний текст.

**Обробка**:
- Розбити текст на слова.
- Для кожного слова:
- Створити множину для зберігання символів.
- Перебрати всі символи слова.
- Якщо символ не зустрічається в множині, додати його.
- Якщо символ вже зустрічається в множині, пропустити його.
- Зберегти перший символ, який не був доданий до множини.
- Створити множину для зберігання знайдених символів.
- Перебрати всі знайдені символи.
- Якщо символ не зустрічається в множині, повернути його.
- Якщо символ вже зустрічається в множині, пропустити його.

**Вихід**: Перший унікальний символ у тексті.
