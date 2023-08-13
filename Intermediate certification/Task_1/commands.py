from datetime import datetime
from file import read, rewrite, get_cur_id


def create_new_note():
    
    header = create_header()
    msg = create_msg()
    id = get_cur_id()
    change_date = datetime.now().strftime('%d-%m-%Y %H:%M:%S')
    result_note = save(id, header, msg, change_date)
    return result_note


def create_header():
    header = input('Введите заголовок заметки: ')
    return header


def create_msg():
    msg = input('Введите текст заметки: ')
    return msg


def save(id, header, msg, date):
    
    date_list = {
        'id': id,
        'header': header,
        'msg': msg,
        'date': date
    }
    return date_list


def show_all():
    try:
        data = read()
        for val in data:
            print(val)
    except FileNotFoundError:
        print(f'{"-" * 15}\nЗаметок еще нет\n{"-" * 15}')


def search_note(data_list, search_data, choice):
    
    if choice == 1:
        data = list(filter(lambda x: x['id'] == search_data, data_list))
        if not data:
            print(f'\n\nДанных с таким id нет.\n\n')
        else:
            print(f'\n\nПо вашему запросу найдены следующие заметки: \n\n{data}\n')
    elif choice == 2:
        data = list(filter(lambda x: x['header'] == search_data, data_list))
        if not data:
            print(f'\n\nДанных с таким id нет.\n\n')
        else:
            print(f'\n\nПо вашему запросу найдены следующие заметки: \n\n{data}\n')
    elif choice == 3:
        data = list(filter(lambda x: x['msg'] == search_data, data_list))
        if not data:
            print(f'\n\nДанных с таким id нет.\n\n')
        else:
            print(f'\n\nПо вашему запросу найдены следующие заметки: \n\n{data}\n')
    elif choice == 4:
        data = list(filter(lambda x: x['date'] == search_data, data_list))
        if not data:
            print(f'\n\nДанных с таким id нет.\n\n')
        else:
            print(f'\n\nПо вашему запросу найдены следующие заметки: \n\n{data}\n')


def delete(data_list: list, key, value):
    for index, dict_ in enumerate(data_list):
        if key in dict_ and dict_[key] == value:
            data_list.remove(dict_)
            print(f'Запись удалена: {dict_}')
        rewrite(data_list)


def edit(data_list: list, key, value):
    for i, dict_ in enumerate(data_list):
        if key in dict_ and dict_[key] == value:
            new_header = ''
            new_msg = ''
            change_header = input(f'Изменить заголовок заметки: "{dict_.get("header")}"\n'
                                 f'1 - Да\n'
                                 f'2 - Нет\n')
            if change_header == '1':
                new_header = input(f'Введите новый заголовок заметки: ')
            elif change_header == '2':
                new_header = dict_.get('header')
            else:
                print('\nВведено неверное значение!\n')
            change_msg = input(f'Изменить текст заметки: "{dict_.get("msg")}"\n'
                               f'1 - Да\n'
                               f'2 - Нет\n')
            if change_msg == '1':
                new_msg = input(f'Введите новый текст заметки: ')
            elif change_msg == '2':
                new_msg = dict_.get('msg')
            else:
                print('\nВведено неверное значение!\n')
            data_list[i] = {
                'id': value,
                'header': new_header,
                'msg': new_msg,
                'date': datetime.now().strftime('%d-%m-%Y %H:%M:%S')
            }
            print(f'Заметка изменена с {dict_} на {data_list[i]}')
    rewrite(data_list)